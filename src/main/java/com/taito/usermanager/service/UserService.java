package com.taito.usermanager.service;

import java.util.List;

import com.taito.usermanager.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto getUserById(Long id);
	
	List<UserDto> getUserByName(String name);
	
	List<UserDto> getUsers();
	
	UserDto  updateUser(Long id, UserDto userDto);
	
	void deleteUserById(Long id);
	
}