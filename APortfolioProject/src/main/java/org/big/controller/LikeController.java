package org.big.controller;

import org.big.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LikeController {

	@Autowired
	private LikeService likeService;

	@PostMapping("/likes/{review_id}/{user_id}")
	@ResponseBody
	public String toggleLike(@PathVariable Long review_id, @PathVariable Long user_id) {
		likeService.toggleLike(review_id, user_id);
		
		return "success";
	}

	@RequestMapping("/likes/{review_id}/count")
	@ResponseBody
	public int getLikeCount(@PathVariable Long review_id) {
		System.out.println("========== 좋아요 조회 ==========");
		
		return likeService.getLikeCount(review_id);
	}

}
