package org.big.service;

import java.util.List;

import org.big.dto.ReviewDto;

public interface ReviewService {

	void addReview(ReviewDto review);

	List<ReviewDto> getReviewsByMovieId(Long movie_id);

	ReviewDto getReviewsByReviewId(Long review_id);

	void reviewDelete(long review_id);

	List<ReviewDto> getPagedReviewsByMovieId(Long movie_id, int pageSize, int offset);

	int countReviewsByMovieId(Long movie_id);

	List<ReviewDto> searchReviews(Long movie_id, String type, String keyword, int pageSize, int offset);

	int countSearchReviews(Long movie_id, String type, String keyword);
}
