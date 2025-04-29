package org.big.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MovieDto {

	private Long id;
	private Long tmdb_id;
	private String title;
	private LocalDate release_date;
	private String poster_path;
	private String overview;
	private Double rating;
}
