package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.application.data.LoginRequestBody;
import com.jld.keycloackapi.application.data.LoginResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LoginServiceImpl implements LoginService {

	@Value("${keycloak.auth-server-url}")
	String baseUri;

	@Value("${keycloak.realm}")
	String realm;

	private RestTemplate restTemplate = new RestTemplate();


	@Override
	public ResponseEntity<LoginResponseBody> login(LoginRequestBody requestBody) {
		if(!requestBody.isValid()) return null;
		String url = new StringBuilder().append(baseUri).append("/realms/").append(realm).append("/protocol/openid-connect/token").toString();
		return restTemplate.getForEntity(url, LoginResponseBody.class);
	}
}
