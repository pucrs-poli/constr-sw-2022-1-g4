package com.jld.keycloackapi.application.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UserController {

	@GetMapping
	public void getAllUsers() {
	}

	@GetMapping(path = "/{id}")
	public void getUser() {
	}

	@PostMapping
	public void createUser() {
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
