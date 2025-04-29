package org.big.controller;

import java.util.List;

import org.big.dto.MovieDto;
import org.big.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;

	// 영화 조회
	@RequestMapping("/movies/fetch")
	public String fetchMovies() {
		System.out.println("========== 영화 조회 ==========");
		
		movieService.fetchAndSaveMovies();
		
		return "redirect:/movies/list";
	}

	// 영화 목록 이동
	@RequestMapping("/movies/list")
	public String getMovieList(Model model) {
		System.out.println("========== 영화 목록 이동 ==========");
		
		List<MovieDto> movieList = movieService.getMovieList();

		model.addAttribute("movies", movieList);

		return "/movie/movieList";
	}

	// 영화 상세 페이지
	@RequestMapping("/movies/detail/{id}")
	public String getMovieDetail(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("========== 영화 상세 페이지 이동 ==========");

		MovieDto movie = movieService.getMovieDetail(id);

		if (movie == null) {
			redirectAttributes.addFlashAttribute("error", "영화를 찾을 수 없습니다.");
			return "redirect:/movies/list";
		}

		model.addAttribute("movie", movie);
		System.out.println(movie);

		return "/movie/movieDetail";
	}

}
