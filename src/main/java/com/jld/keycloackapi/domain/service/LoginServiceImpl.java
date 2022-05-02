package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.application.data.LoginRequestBody;
import com.jld.keycloackapi.config.AccessTokenManager;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	AccessTokenManager accessTokenManager;

	private RestTemplate restTemplate = new RestTemplate();
	private String baseUri;
	public LoginServiceImpl(@Value("${baseLoginUri}") String baseUri) {
		this.baseUri = baseUri;
	}

	@Override
	public ResponseEntity<AccessTokenResponse> login(LoginRequestBody loginRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/x-www-form-urlencoded");

		MultiValueMap<String,String> form = new LinkedMultiValueMap<>();
		form.add("client_id",loginRequest.getClient_id());
		form.add("username",loginRequest.getUsername());
		form.add("password",loginRequest.getPassword());
		form.add("grant_type",loginRequest.getGrant_type());
		form.add("client_secret",loginRequest.getClient_secret());


		HttpEntity entity = new HttpEntity(form,headers);
		String url = new StringBuilder().append(baseUri).append("/protocol/openid-connect/token").toString();

		ResponseEntity<AccessTokenResponse> responseEntity = restTemplate.postForEntity(
				url,
				entity, AccessTokenResponse.class
		);

		accessTokenManager.add(responseEntity.getBody().getRefreshToken(), responseEntity.getBody().getExpiresIn(),loginRequest.getClient_secret());
		accessTokenManager.logged = true;

		accessTokenManager.start();
		return responseEntity;
	}
}
