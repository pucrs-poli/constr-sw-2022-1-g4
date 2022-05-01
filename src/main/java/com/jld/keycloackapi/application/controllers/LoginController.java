package com.jld.keycloackapi.application.controllers;

import com.jld.keycloackapi.application.data.LoginRequestBody;
import com.jld.keycloackapi.application.data.LoginResponseBody;
import com.jld.keycloackapi.domain.service.LoginServiceImpl;
import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Resource
	private LoginServiceImpl loginService;

	@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<LoginResponseBody> login(@ModelAttribute LoginRequestBody body) {
		return loginService.login(body);
	}

}