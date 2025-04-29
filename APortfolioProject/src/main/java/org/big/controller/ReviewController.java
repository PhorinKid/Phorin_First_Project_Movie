package org.big.controller;

import java.util.List;

import org.big.dto.MovieDto;
import org.big.dto.ReviewDto;
import org.big.dto.UserDto;
import org.big.service.MovieService;
import org.big.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private MovieService movieService;

	// 리뷰 목록
	@RequestMapping("/movies/reviews/{movie_id}")
	public String getReviews(@PathVariable("movie_id") Long movie_id, @RequestParam(defaultValue = "1") int page,
			@RequestParam(required = false) String type, @RequestParam(required = false) String keyword, Model model) {
		System.out.println("========== 리뷰 목록 ==========");
		System.out.println("검색 조건: " + type + " / " + keyword);

		final int pageSize = 15;
		int offset = (page - 1) * pageSize;
		List<ReviewDto> reviews;
		int totalReviews;

		if (keyword != null && !keyword.isEmpty()) {
			// 검색 + 페이징
			reviews = reviewService.searchReviews(movie_id, type, keyword, pageSize, offset);
			totalReviews = reviewService.countSearchReviews(movie_id, type, keyword);
			model.addAttribute("type", type);
			model.addAttribute("keyword", keyword);
		} else {
			// 전체 리뷰 + 페이징
			reviews = reviewService.getPagedReviewsByMovieId(movie_id, pageSize, offset);
			totalReviews = reviewService.countReviewsByMovieId(movie_id);
		}

		MovieDto movie = movieService.getMovieDetail(movie_id);
		int totalPages = (int) Math.ceil((double) totalReviews / pageSize);

		model.addAttribute("movie", movie);
		model.addAttribute("reviews", reviews);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalReviews", totalReviews);

		return "/review/reviewList";
	}

	// 리뷰 작성
	@RequestMapping("/reviews/reviewWrite/{movie_id}")
	public String reviewWrite(@PathVariable("movie_id") Long movie_id, HttpSession session, Model model) {
		System.out.println("========== 리뷰 작성 ==========");
		
		MovieDto movie = movieService.getMovieDetail(movie_id);
		UserDto user = (UserDto) session.getAttribute("user");

		model.addAttribute("movie", movie);
		model.addAttribute("user", user);

		return "/review/reviewWrite";
	}

	// 리뷰 작성 완료
	@RequestMapping("/reviews/add")
	public String addReview(@ModelAttribute ReviewDto review) {
		System.out.println("========== 리뷰 작성 완료 ==========");
		
		reviewService.addReview(review);

		return "redirect:/movies/reviews/" + review.getMovie_id();
	}

	// 리뷰 상세
	@RequestMapping("/reviews/{review_id}")
	public String reviewDetail(@PathVariable("review_id") Long review_id, Model model, HttpSession session) {
		System.out.println("========== 리뷰 상세 ==========");
		
		UserDto user = (UserDto) session.getAttribute("user");
		ReviewDto review = reviewService.getReviewsByReviewId(review_id);
		MovieDto movie = movieService.getMovieDetail(review.getMovie_id());

		model.addAttribute("user", user);
		model.addAttribute("review", review);
		model.addAttribute("movie", movie);

		return "/review/reviewDetail";
	}

	// 리뷰 삭제
	@RequestMapping("/reviews/delete/{review_id}")
	public String reviewDelete(@PathVariable("review_id") Long review_id, @RequestParam Long movie_id) {
		System.out.println("========== 리뷰 삭제 ==========");
		
		reviewService.reviewDelete(review_id);

		return "redirect:/movies/reviews/" + movie_id;
	}

}
