package org.big.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.big.dto.ReviewDto;

@Mapper
public interface ReviewMapper {

	void insertReview(ReviewDto review); // 리뷰 추가

	List<ReviewDto> getReviewsByMovieId(@Param("movie_id") Long movie_id); // 특정 영화의 리뷰 조회

	ReviewDto getReviewsByReviewId(@Param("review_id") Long review_id); // 특정 리뷰 조회

	void reviewDelete(long review_id); // 리뷰 삭제

	List<ReviewDto> getPagedReviewsByMovieId(@Param("movie_id") Long movie_id, @Param("pageSize") int pageSize, @Param("offset") int offset);

	int countReviewsByMovieId(Long movie_id);

	List<ReviewDto> searchReviews(@Param("movie_id") Long movie_id, @Param("type") String type, @Param("keyword") String keyword, @Param("pageSize") int pageSize, @Param("offset") int offset);

	int countSearchReviews(Long movie_id, String type, String keyword);
}
