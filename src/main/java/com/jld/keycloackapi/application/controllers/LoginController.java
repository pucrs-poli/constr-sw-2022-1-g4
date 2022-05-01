package com.jld.keycloackapi.application.controllers;

import com.jld.keycloackapi.application.data.LoginRequestBody;
import com.jld.keycloackapi.application.data.LoginResponseBody;
import com.jld.keycloackapi.domain.service.LoginServiceImpl;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Resource
	private LoginServiceImpl loginService;

	@PostMapping
	public ResponseEntity<LoginResponseBody> login(final @RequestBody LoginRequestBody body) {
		return loginService.login(body);
	}

}