package org.big.service;

import java.util.List;
import java.util.Map;

import org.big.dto.MovieDto;
import org.big.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;

	@Value("${tmdb.api.key}")
	private String apiKey;

	@Value("${tmdb.api.url}")
	private String apiUrl;

	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public void fetchAndSaveMovies() { // 영화 등록
		// TODO Auto-generated method stub
		String url = apiUrl + "/movie/popular?api_key=" + apiKey + "&language=ko-KR&page=1";
		System.out.println(url);

		// TMDB API 호출
		Map<String, Object> response = restTemplate.getForObject(url, Map.class);
		if (response == null || !response.containsKey("results")) {
			throw new RuntimeException("TMDB API 응답 오류");
		}

		List<Map<String, Object>> movies = (List<Map<String, Object>>) response.get("results");

		for (Map<String, Object> movieData : movies) {
			MovieDto movie = new MovieDto();
			movie.setTmdb_id(((Number) movieData.get("id")).longValue());
			movie.setTitle((String) movieData.get("title"));
			movie.setRelease_date(java.time.LocalDate.parse((String) movieData.get("release_date")));
			movie.setPoster_path((String) movieData.get("poster_path"));
			movie.setOverview((String) movieData.get("overview"));
			movie.setRating(movieData.get("vote_average") != null ? ((Number) movieData.get("vote_average")).doubleValue() : 0.0);

			// 중복 방지 (TMDB ID 기준)
			if (movieMapper.getMovieByTmdbId(movie.getTmdb_id()) == null) {
				movieMapper.insertMovie(movie);
			}
		}
	}

	@Override
	public List<MovieDto> getMovieList() { // 영화 목록 조회
		// TODO Auto-generated method stub
		return movieMapper.getAllMovies();
	}

	@Override
	public MovieDto getMovieDetail(Long id) { // 상세 영화 조회
		// TODO Auto-generated method stub
		return movieMapper.getMovieById(id);
	}

}
