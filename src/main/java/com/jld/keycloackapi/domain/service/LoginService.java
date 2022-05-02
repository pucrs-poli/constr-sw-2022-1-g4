package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.application.data.LoginRequestBody;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;

public interface LoginService {

	ResponseEntity<AccessTokenResponse> login(LoginRequestBody loginRequest);

}
