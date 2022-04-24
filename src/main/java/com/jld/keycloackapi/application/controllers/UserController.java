package com.jld.keycloackapi.application.controllers;

import com.jld.keycloackapi.domain.dto.UserDTO;
import com.jld.keycloackapi.domain.service.UserService;
import jdk.jfr.ContentType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {

	@Resource
	private UserService userService;

	@GetMapping
	public void getAllUsers() {
		userService.getAllUsers();
	}

	@GetMapping(path = "/{id}")
	public void getUser() {
	}

	@PostMapping
	public void createUser(@RequestBody UserDTO userDTO) {
		userService.createUser(userDTO);
	}

	@PutMapping(path = "/{id}")
	public void updateUser() {
	}

	@PatchMapping(path = "/{id}")
	public void updateUserPassword() {
	}

	@DeleteMapping(path = "/{id}")
	public void deleteUser() {
	}

}
