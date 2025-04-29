package org.big.service;

import java.util.List;

import org.big.dto.MovieDto;

public interface MovieService {

	void fetchAndSaveMovies(); // TMDB API에서 영화 데이터를 가져와 DB에 저장

	List<MovieDto> getMovieList(); // DB에 저장된 영화 목록 조회

	MovieDto getMovieDetail(Long id); // 특정 영화 상세 정보 조회

}
