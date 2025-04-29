package org.big.service;

import org.big.dto.UserDto;
import org.big.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void registerUser(UserDto user) {
		// TODO Auto-generated method stub
		userMapper.insertUser(user);
	}

	@Override
	public boolean isMemberIdExists(String memberId) {
		// TODO Auto-generated method stub
		return userMapper.existsByMemberId(memberId) > 0;
	}

	@Override
	public boolean isEmailExists(String email) {
		// TODO Auto-generated method stub
		return userMapper.existsByEmail(email) > 0;
	}

	@Override
	public UserDto login(UserDto user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	@Override
	public void updateUser(UserDto user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(id);
	}
}