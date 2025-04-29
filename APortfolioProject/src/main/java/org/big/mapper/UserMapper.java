package org.big.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.big.dto.UserDto;

@Mapper
public interface UserMapper {

	void insertUser(UserDto user); // 회원가입

	int existsByMemberId(String memberId); // 아이디 중복 체크

	int existsByEmail(String email); // 이메일 중복 체크

	UserDto login(UserDto user); // 로그인

	void updateUser(UserDto user); // 회원 정보 수정

	void deleteUser(long id); // 회원 탈퇴

}
