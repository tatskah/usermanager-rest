package com.taito.usermanager.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taito.usermanager.dto.UserDto;
import com.taito.usermanager.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("users")
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto eventDto) {
		UserDto savedUser = userService.createUser(eventDto);
		return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> users = userService.getUsers();
		return ResponseEntity.ok(users);

	}

	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
		UserDto user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping("name/{name}")
	public ResponseEntity<List<UserDto>>  getUserByName(@PathVariable("name") String name) {
		List<UserDto>users = userService.getUserByName(name);
		return ResponseEntity.ok(users);
	}

	
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto eventDto) {
		UserDto eventUpdated = userService.updateUser(id, eventDto);

		return ResponseEntity.ok(eventUpdated);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return ResponseEntity.ok("User deleted by id: " + id);
	}

	// With links
//	@GetMapping
//	public ResponseEntity<CollectionModel<EntityModel<User>>> getAllUsers() {
//		List<EntityModel<User>> users = StreamSupport.stream(userRepository.findAll().spliterator(), true)
//				.map(user -> EntityModel.of(user,
//						linkTo(methodOn(UserController.class).getUserByIdWith(user.getId())).withSelfRel(),
//						linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel()))
//				.collect(Collectors.toList());
//
//		return ResponseEntity.ok(CollectionModel.of(users));
//	}
//
//	@GetMapping("{id}")
//	ResponseEntity<EntityModel<User>> getUserByIdWith(@PathVariable("id") Long id) {
//		User event = userRepository.findById(id)
//				.orElseThrow(() -> new DataNotFoundException("Data not found by id: " + id));
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userModelAssembler.toModel(event));
//
//	}
//
//	@PostMapping
//	ResponseEntity<EntityModel<User>> addUser(@RequestBody User user) {
//		User userSaved = userRepository.save(user);
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(userModelAssembler.toModel(userSaved));
//	}
//
//	@PutMapping("{id}")
//	public ResponseEntity<EntityModel<User>> updateUser(@PathVariable("id") Long id, @RequestBody User userToSave) {
//		User user = userRepository.findById(id)
//				.orElseThrow(() -> new DataNotFoundException("Data not found by id: " + id));
//		user.setName(userToSave.getName());
//		user.setUsername(userToSave.getUsername());
//		user.setPhone(userToSave.getPhone());
//		user.setEmail(userToSave.getEmail());
//		user.setAddress(userToSave.getAddress());
//		user.setCompany(userToSave.getCompany());
//		user.setWebsite(userToSave.getWebsite());
//
//		User userSaved = userRepository.save(user);
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(userModelAssembler.toModel(userSaved));
//	}
//
//	@DeleteMapping("{id}")
//	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
//		userRepository.deleteById(id);
//		return ResponseEntity.ok("User deleted by id: " + id);
//	}
//
//	@RequestMapping("name/{name}")
//	EntityModel<User> getUserName(@PathVariable("name") String name) {
//		User user = (User) userRepository.findByName(name);
//		
//		return null;
//		
//	
//	}

}
