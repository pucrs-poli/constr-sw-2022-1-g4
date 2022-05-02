package com.jld.keycloackapi.application.controllers;

import com.jld.keycloackapi.domain.dto.UserDTO;
import com.jld.keycloackapi.domain.service.UserServiceImpl;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {

	@Resource
	private UserServiceImpl userService;

	@GetMapping
	public ResponseEntity<String> getAllUsers(@RequestHeader("Authorization") String Authorization) {
		return userService.getAllUsers(Authorization);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<String> getUser(@RequestHeader("Authorization") String Authorization, @PathVariable("id") String id) {
		return userService.getUser(Authorization,id);
	}

	@PostMapping
	public ResponseEntity<String> createUser(@RequestHeader("Authorization") String Authorization, @RequestBody UserDTO userDTO) {
		return userService.createUser(Authorization,userDTO);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<UserRepresentation> updateUser(
		@RequestHeader("Authorization") String Authorization,
		@RequestBody UserDTO userDTO,
		@PathVariable("id") String id) {
		return userService.updateUser(Authorization,userDTO,id);
	}

	@PatchMapping(path = "/{id}")
	public ResponseEntity<UserRepresentation> updateUserPassword(
		final @RequestHeader("Authorization") String Authorization,
		final @RequestBody UserDTO userDTO,
		final @PathVariable("id") String id) {
		return userService.updateUserPassword(Authorization, userDTO,id);
	}

	@DeleteMapping(path ="/{id}")
	public ResponseEntity<String>  deleteUser(@RequestHeader("Authorization") String Authorization, @PathVariable("id") String id) {
		return new ResponseEntity<>("",userService.deleteUser(Authorization,id));
	}

}
