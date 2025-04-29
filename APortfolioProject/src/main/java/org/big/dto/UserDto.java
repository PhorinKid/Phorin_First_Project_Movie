package org.big.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDto {

	private Long id;
	private String member_id;
	private String password;
	private String username;
	private String email;
	private String role = "USER";
	private LocalDateTime created_at;

	private String confirmPassword;

}
