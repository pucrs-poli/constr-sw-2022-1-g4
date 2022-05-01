package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.application.data.LoginRequestBody;
import com.jld.keycloackapi.application.data.LoginResponseBody;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
	public ResponseEntity<LoginResponseBody> login(LoginRequestBody loginRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String,String> form = new LinkedMultiValueMap<>();
		form.add("client_id",loginRequest.getClient_id());
		form.add("username",loginRequest.getUsername());
		form.add("password",loginRequest.getPassword());
		form.add("grant_type",loginRequest.getGrant_type());


		HttpEntity entity = new HttpEntity(form,headers);
		String url = new StringBuilder().append(baseUri).append("/protocol/openid-connect/token").toString();

		return restTemplate.exchange(
			url,
			HttpMethod.POST,
			entity,
			LoginResponseBody.class
		);
	}
}
