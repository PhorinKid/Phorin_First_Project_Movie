package org.big.service;

import org.big.dto.UserDto;

public interface UserService {

	void registerUser(UserDto user); // 회원가입

	boolean isMemberIdExists(String memberId); // 아이디 중복 체크

	boolean isEmailExists(String email); // 이메일 중복 체크

	UserDto login(UserDto user); // 로그인

	void updateUser(UserDto user); // 회원 정보 수정

	void deleteUser(long id); // 회원 탈퇴

}
