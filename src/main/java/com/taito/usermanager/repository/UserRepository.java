package com.taito.usermanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taito.usermanager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByName(String name);
	
}
