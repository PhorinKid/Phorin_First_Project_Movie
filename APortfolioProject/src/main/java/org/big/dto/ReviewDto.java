package org.big.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReviewDto {

	private Long id;
	private Long movie_id;
	private Long user_id;
	private String content;
	private Double rating;
	private LocalDateTime created_at;
	private int like_count;
    private String review_title;
    
    private String dates;
    private String member_id;

}
