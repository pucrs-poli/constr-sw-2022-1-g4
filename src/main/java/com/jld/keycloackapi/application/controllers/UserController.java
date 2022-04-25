package com.jld.keycloackapi.application.controllers;

import com.jld.keycloackapi.domain.dto.UserDTO;
import com.jld.keycloackapi.domain.service.UserService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.PathParam;

@RestController
@RequestMapping("/users")
public class UserController {

	@Resource
	private UserService userService;

	@GetMapping
	public ResponseEntity<String> getAllUsers(@RequestHeader("Authorization") String Authorization) {
		return userService.getAllUsers(Authorization);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<String> getUser(@RequestHeader("Authorization") String Authorization, String id) {
		return userService.getUser(Authorization,id);
	}

	@PostMapping
	public ResponseEntity<UserRepresentation> createUser(@RequestHeader("Authorization") String Authorization, @RequestBody UserDTO userDTO) {
		return userService.createUser(Authorization,userDTO);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<UserRepresentation> updateUser(@RequestHeader("Authorization") String Authorization, @RequestBody UserDTO userDTO, String id) {
		return userService.updateUser(Authorization,userDTO,id);
	}

	@PatchMapping(path = "/{id}")
	public ResponseEntity<UserRepresentation> updateUserPassword(@RequestHeader("Authorization") String Authorization, @RequestBody UserDTO userDTO, String id) {
		return userService.updateUserPassword(Authorization, userDTO,id);
	}

	@DeleteMapping(path ="/{id}")
	public HttpStatus deleteUser(@RequestHeader("Authorization") String Authorization, @PathParam("id") String id) {
		return userService.deleteUser(Authorization,id);
	}

}
