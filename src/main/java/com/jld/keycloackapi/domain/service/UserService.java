package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.domain.dto.UserDTO;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService implements IUserService {
	@Value("${keycloak.auth-server-url}")
	String baseUri;

	@Value("${keycloak.realm}")
	String realm;

	private RestTemplate restTemplate = new RestTemplate();

//	@Value("${keycloak.url.auth}")
//	private String auth_endpoint;
//
//	@Value("${keycloak.url.token}")
//	private String token_endpoint;

	private List<UserRepresentation> ResponseEntity;


	private MultiValueMap<String, String> headers(String token) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Authorization", token);
		return headers;
	}


	@Override
	public ResponseEntity<String> getUser(String Authorization, String id) {
		String getUsers = "http://localhost:8080/auth/admin/realms/oauth2-demo-realm/users";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization",Authorization);
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		return restTemplate.exchange(
				getUsers, HttpMethod.GET, requestEntity, String.class,id);
	}

	@Override
	public ResponseEntity<String> getAllUsers(String Authorization) {
		String getUsers = "http://localhost:8080/auth/admin/realms/oauth2-demo-realm/users";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization",Authorization);
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		return restTemplate.exchange(
				getUsers, HttpMethod.GET, requestEntity, String.class,"");
	}

	@Override
	public HttpStatus deleteUser(String Authorization, String id) {
		String getUsers = "http://localhost:8080/auth/admin/realms/oauth2-demo-realm/users";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", Authorization);
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		HashMap<String,String> param = new HashMap<>();
		param.put("id", id);
//		restTemplate.exchange(getUsers, HttpMethod.DELETE, requestEntity, Void.class, id);
		try {
		restTemplate.exchange(getUsers, HttpMethod.DELETE, requestEntity, Void.class, param);
			return HttpStatus.OK;
		} catch (Exception ignored) {
			return HttpStatus.BAD_REQUEST;

		}

	}

	@Override
	public ResponseEntity<UserRepresentation> createUser(String Authorization, UserDTO userDTO) {

		String getUsers = "http://localhost:8080/auth/admin/realms/oauth2-demo-realm/users";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization",Authorization);

		UserRepresentation user = userRepresentation(userDTO, credentialRepresentation(userDTO));

		HttpEntity<UserRepresentation> requestEntity =
				new HttpEntity<>(user,headers);

		return restTemplate.exchange(
				getUsers, HttpMethod.POST, requestEntity, UserRepresentation.class);

	}

	@Override
	public ResponseEntity<UserRepresentation> updateUser(String Authorization,UserDTO userDTO, String id) {
		String getUsers = "http://localhost:8080/auth/admin/realms/oauth2-demo-realm/users";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization",Authorization);

		UserRepresentation user = userRepresentation(userDTO, credentialRepresentation(userDTO));

		HttpEntity<UserRepresentation> requestEntity =
				new HttpEntity<>(user,headers);

		return restTemplate.exchange(
				getUsers, HttpMethod.PUT, requestEntity, UserRepresentation.class);
	}

	@Override
	public ResponseEntity<UserRepresentation> updateUserPassword(String Authorization,UserDTO userDTO, String id) {
		UserRepresentation user = userRepresentation(userDTO, credentialRepresentation(userDTO));
		String getUsers = "http://localhost:8080/auth/admin/realms/oauth2-demo-realm/users";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization",Authorization);

		HttpEntity<UserRepresentation> requestEntity =
				new HttpEntity<>(user,headers);

		return restTemplate.exchange(
				getUsers, HttpMethod.PATCH, requestEntity, UserRepresentation.class);

	}

	private CredentialRepresentation credentialRepresentation(UserDTO userDTO) {
		CredentialRepresentation password = new CredentialRepresentation();
		password.setTemporary(false);
		password.setType(CredentialRepresentation.PASSWORD);
		password.setValue(userDTO.getPassword());
		return password;
	}

	private UserRepresentation userRepresentation (UserDTO userDTO, CredentialRepresentation passwords){
		UserRepresentation user = new UserRepresentation();
		user.setEnabled(true);
		user.setUsername(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstname());
		user.setLastName(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());
		user.setCredentials(List.of(passwords));

		return user;
	}

}
