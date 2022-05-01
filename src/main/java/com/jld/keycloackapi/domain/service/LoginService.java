package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.application.data.LoginRequestBody;
import com.jld.keycloackapi.application.data.LoginResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public interface LoginService {

	ResponseEntity<LoginResponseBody> login(LoginRequestBody loginRequest);

}
