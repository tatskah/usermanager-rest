package com.taito.usermanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taito.usermanager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
	List<User> findByName(@Param("name") String name);
}
