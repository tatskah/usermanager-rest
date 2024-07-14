package com.taito.usermanager.mapper;

import com.taito.usermanager.dto.UserDto;
import com.taito.usermanager.model.Address;
import com.taito.usermanager.model.Company;
import com.taito.usermanager.model.User;

public class UserMapper {

	public static UserDto mapToUserDto(User user) {
		return new UserDto(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getPhone(),
				user.getWebsite(), user.getAddress(), user.getCompany());
	}

	public static User mapToUser(UserDto userDot) {
		return new User(userDot.getId(), userDot.getName(), userDot.getUsername(), userDot.getEmail(),
				userDot.getPhone(), userDot.getWebsite(), userDot.getAddress(), userDot.getCompany());
	}
}