package org.big.controller;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.big.dto.UserDto;
import org.big.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 기본 페이지
	@RequestMapping("/welcomes") 
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome");
		model.addAttribute("tagline", "Welcome to Movie");
		model.addAttribute("currentTime", new Date());
		return "/welcome";
	}

	// 메뉴
	@RequestMapping("/menus")
	public String menu(HttpSession session, Model model) {
		UserDto user = getLoginUser(session);
		
		model.addAttribute("user", user);
		
		return "/menu";
	}

	// 바닥글
	@RequestMapping("/footers")
	public String footer() {
		return "/footer";
	}

	// 회원 가입 페이지 이동
	@RequestMapping("/members/addMember") 
	public String addMember() {
		System.out.println("========== 회원 가입 페이지 ===========");
		
		return "/member/addMember";
	}

	// 아이디 중복 체크
	@PostMapping("/members/checkMemberId") 
	@ResponseBody
	public Map<String, Boolean> checkMemberId(@RequestParam String member_id) {
		boolean exists = userService.isMemberIdExists(member_id);
		return Collections.singletonMap("exists", exists);
	}

	// 이메일 중복 체크
	@PostMapping("/members/checkEmail") 
	@ResponseBody
	public Map<String, Boolean> checkEmail(@RequestParam String email) {
		boolean exists = userService.isEmailExists(email);
		return Collections.singletonMap("exists", exists);
	}

	// 회원가입
	@RequestMapping("/members/addProcess") 
	public String registerUser(@ModelAttribute UserDto user, RedirectAttributes redirectAttributes) {
		System.out.println("========== 회원가입 ===========");
		try { // 비밀번호와 비밀번호 확인이 일치하는지 확인
			if (!user.getPassword().equals(user.getConfirmPassword())) {
				redirectAttributes.addFlashAttribute("error", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				return "redirect:/members/addMember"; // 오류 발생 시 다시 회원가입 페이지로 이동
			}
			userService.registerUser(user);
			redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다.");
			return "redirect:/members/login"; // 회원가입 후 로그인 페이지로 이동
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "회원가입 중 오류가 발생했습니다.");
			return "redirect:/members/addMember"; // 오류 발생 시 다시 회원가입 페이지로 이동
		}
	}

	// 로그인 페이지 이동
	@RequestMapping("/members/login")
	public String loginPage() {
		System.out.println("========== 로그인 페이지 ===========");
		
		return "/member/loginMember";
	}

	// 로그인
	@RequestMapping("/members/loginProcess")
	public String loginProcess(@ModelAttribute UserDto user, RedirectAttributes redirectAttributes, HttpSession session) {
		System.out.println("========== 로그인 ===========");

		UserDto login = userService.login(user);
		
		if (login != null) {
			session.setAttribute("user", login);
			return "redirect:/welcomes";
		} else {
			redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
			return "redirect:/members/login";
		}
	}

	// 로그아웃
	@RequestMapping("/members/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
		System.out.println("========== 로그아웃 ===========");
		
		session.invalidate();
		redirectAttributes.addFlashAttribute("message", "로그아웃 되었습니다.");
		
		return "redirect:/welcomes";
	}

	// 회원 수정 페이지
	@RequestMapping("/members/update")
	public String updateMember(HttpSession session, Model model) {
		System.out.println("========== 회원 수정 페이지 ===========");
		
		UserDto user = getLoginUser(session);
		
		if (user == null) {
			return "redirect:/members/login";
		}
		model.addAttribute("user", user);
		
		return "/member/editMember";
	}

	// 회원 수정
	@RequestMapping("/members/editMember")
	public String editMember(@ModelAttribute UserDto users, RedirectAttributes redirectAttributes, HttpSession session) {
		System.out.println("========== 회원 수정 ===========");
		
		try {
			UserDto user = getLoginUser(session);
			
			if (users.getPassword() != null && !users.getPassword().isEmpty()) { // 비밀번호 입력 시
				if (!users.getPassword().equals(users.getConfirmPassword())) { // 비밀번호 불일치
					redirectAttributes.addFlashAttribute("error", "비밀번호가 일치하지 않습니다.");
					return "redirect:/members/update";
				}
				
				System.out.println("비밀번호 변경 : " + users.getPassword()); // 비밀번호 일치
			} else { // 비밀번호 변경 안 할 경우 기존 값 유지
				users.setPassword(user.getPassword());
				System.out.println("비밀번호 유지 : " + user.getPassword()); // 비밀번호 유지
			}
			
			users.setMember_id(user.getMember_id());
			userService.updateUser(users);
			user = userService.login(users);
			redirectAttributes.addFlashAttribute("message", "회원 정보가 수정되었습니다.");
			
			return "redirect:/welcomes";
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "회원 정보 수정 중 오류가 발생했습니다.");
			return "redirect:/members/update";
		}
	}

	// 회원 탈퇴 페이지
	@RequestMapping("/members/delete") 
	public String delete() {
		System.out.println("========== 회원 탈퇴 페이지 ===========");
		return "/member/deleteMember";
	}

	// 회원 탈퇴
	@RequestMapping("/members/deletemember")
	public String deleteMember(HttpSession session, RedirectAttributes redirectAttributes) {
		System.out.println("========== 회원 탈퇴 ===========");
		
		UserDto user = getLoginUser(session);
		
		if (user == null) {
			redirectAttributes.addFlashAttribute("error", "로그인이 필요합니다.");
			return "redirect:/members/login";
		}
		
		try {
			userService.deleteUser(user.getId());
			session.invalidate();
			redirectAttributes.addFlashAttribute("message", "회원 탈퇴가 완료되었습니다.");
			return "redirect:/welcomes";
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "회원 탈퇴 중 오류가 발생했습니다.");
			return "redirect:/members/delete";
		}
	}

	private UserDto getLoginUser(HttpSession session) {
		return (UserDto) session.getAttribute("user");
	}

}
