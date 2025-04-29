package org.big.service;

import java.util.List;

import org.big.dto.ReviewDto;
import org.big.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	@Override
	public void addReview(ReviewDto review) {
		// TODO Auto-generated method stub
		reviewMapper.insertReview(review);
	}

	@Override
	public List<ReviewDto> getReviewsByMovieId(Long movie_id) {
		// TODO Auto-generated method stub
		return reviewMapper.getReviewsByMovieId(movie_id);
	}
	
	@Override
	public ReviewDto getReviewsByReviewId(Long review_id) {
		// TODO Auto-generated method stub
		return reviewMapper.getReviewsByReviewId(review_id);
	}
	
	@Override
	public void reviewDelete(long review_id) {
		// TODO Auto-generated method stub
		reviewMapper.reviewDelete(review_id);
	}
	
	@Override
	public List<ReviewDto> getPagedReviewsByMovieId(Long movie_id, int pageSize, int offset) {
		// TODO Auto-generated method stub
		return reviewMapper.getPagedReviewsByMovieId(movie_id, pageSize, offset);
	}
	
	@Override
	public int countReviewsByMovieId(Long movie_id) {
		// TODO Auto-generated method stub
		return reviewMapper.countReviewsByMovieId(movie_id);
	}
	
	@Override
	public List<ReviewDto> searchReviews(Long movie_id, String type, String keyword, int pageSize, int offset) {
		// TODO Auto-generated method stub
		return reviewMapper.searchReviews(movie_id, type, keyword, pageSize, offset);
	}
	
	@Override
	public int countSearchReviews(Long movie_id, String type, String keyword) {
		// TODO Auto-generated method stub
		return reviewMapper.countSearchReviews(movie_id, type, keyword);
	}
}
