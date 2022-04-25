package com.jld.keycloackapi.application.controllers;

import com.jld.keycloackapi.domain.dto.UserDTO;
import com.jld.keycloackapi.domain.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {

	@Resource
	private UserService userService;

	@GetMapping
	@PreAuthorize("hasAnyAuthority('ROLE_user')")
	public void getAllUsers() {
		userService.getAllUsers();
	}

	@GetMapping(path = "/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_user')")
	public void getUser(@RequestParam String id) {
		userService.getUser(id);
	}

	@PostMapping
	@PreAuthorize("hasAnyAuthority('ROLE_user')")
	public void createUser(@RequestBody UserDTO userDTO) {
		userService.createUser(userDTO);
	}

	@PutMapping(path = "/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_user')")
	public void updateUser(@RequestBody UserDTO userDTO, String id) {
		userService.updateUser(userDTO,id);
	}

	@PatchMapping(path = "/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_user')")
	public void updateUserPassword(@RequestBody UserDTO userDTO, String id) {
		userService.updateUserPassword(userDTO,id);
	}

	@DeleteMapping(path = "/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_user')")
	public void deleteUser(@RequestParam String id) {
		userService.deleteUser(id);
	}

}
