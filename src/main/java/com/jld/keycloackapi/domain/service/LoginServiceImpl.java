package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.application.data.LoginRequestBody;
import com.jld.keycloackapi.application.data.LoginResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl implements LoginService {

	private String baseUri;
	@Value("${keycloak.realm}")
	String realm;

	private RestTemplate restTemplate = new RestTemplate();

	public LoginServiceImpl(@Value("${baseLoginUri}") String baseUri) {
		this.baseUri = baseUri;
	}



	@Override
	public ResponseEntity<LoginResponseBody> login(LoginRequestBody requestBody) {
		if(!requestBody.isValid()) return null;
		String url = new StringBuilder().append(baseUri).append("/protocol/openid-connect/token").toString();
		return restTemplate.postForEntity(url, requestBody, LoginResponseBody.class);
	}
}
