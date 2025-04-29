package org.big.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.big.dto.MovieDto;

@Mapper
public interface MovieMapper {

	void insertMovie(MovieDto movie); // 영화 데이터 저장

	List<MovieDto> getAllMovies(); // 영화 목록 조회

	MovieDto getMovieById(Long id); // 영화 상세 조회

	MovieDto getMovieByTmdbId(Long tmdbId); // 중복 체크용
	
}
