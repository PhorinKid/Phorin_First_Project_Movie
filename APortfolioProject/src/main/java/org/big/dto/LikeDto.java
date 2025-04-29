package org.big.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LikeDto {

	private long id;
	private long user_id;
	private long review_id;
	private LocalDateTime created_at;

}
