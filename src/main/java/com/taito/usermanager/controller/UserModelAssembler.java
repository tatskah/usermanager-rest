package com.taito.usermanager.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.taito.usermanager.model.User;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

	@Override
	public EntityModel<User> toModel(User user) {
		return EntityModel.of(user,
				linkTo(methodOn(UserController.class).getUserById(user.getId())).withSelfRel(),
				linkTo(methodOn(UserController.class).getUsers()).withRel("users"),
				linkTo(methodOn(UserController.class).deleteUser(user.getId())).withRel("delete"));
	}

}
