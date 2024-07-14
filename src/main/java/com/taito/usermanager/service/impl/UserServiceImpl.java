package com.taito.usermanager.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.taito.usermanager.dto.UserDto;
import com.taito.usermanager.model.User;
import com.taito.usermanager.exception.DataNotFoundException;
import com.taito.usermanager.mapper.UserMapper;
import com.taito.usermanager.repository.UserRepository;
import com.taito.usermanager.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = UserMapper.mapToUser(userDto);
		User savedUser = userRepository.save(user);

		return UserMapper.mapToUserDto(savedUser);
	}

	@Override
	public UserDto getUserById(Long id) {
		User user = this.getUser(id);
		
		return UserMapper.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users.stream().map((user) -> UserMapper.mapToUserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(Long id, UserDto userDto) {
		User user = this.getUser(id);
		
		user.setName(userDto.getName());
		user.setUsername(userDto.getUsername());
		user.setPhone(userDto.getPhone());
		user.setEmail(userDto.getEmail());
		user.setAddress(userDto.getAddress());
		user.setCompany(userDto.getCompany());
		user.setWebsite(userDto.getWebsite());

		
		User savedUser = userRepository.save(user);
		return UserMapper.mapToUserDto(savedUser);
	}

	@Override
	public void deleteUserById(Long id) {
		this.getUser(id);
		
		userRepository.deleteById(id);
	}

	private User getUser(Long id) {						
		User user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User not found by id: " + id));
		return user;
	}

	@Override
	public List<UserDto>  getUserByName(String name) {
		List<User> users = (List<User>) userRepository.findByName(name);
		return users.stream().map((user) -> UserMapper.mapToUserDto(user)).collect(Collectors.toList());
	}

	
}








