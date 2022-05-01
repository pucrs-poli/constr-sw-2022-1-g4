package com.jld.keycloackapi.domain.service;
import com.jld.keycloackapi.domain.dto.UserDTO;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
@Configuration
@Service
public class UserServiceImpl implements UserService {

	private String baseUri;
	@Value("${keycloak.realm}")
	String realm;

	private RestTemplate restTemplate = new RestTemplate();

	public UserServiceImpl(@Value("${baseUri}") String baseUri) {
		this.baseUri = baseUri + "/users";
	}


	@Override
	public ResponseEntity<String> getUser(String authorization, String id) {
		try{
			return restTemplate.exchange(
				baseUri + "/" + id,
				HttpMethod.GET,
				getHttpEntity(authorization),
				String.class
			);
		}catch (Exception ignored){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<String> getAllUsers(String authorization) {
		return restTemplate.exchange(
			baseUri,
			HttpMethod.GET,
			getHttpEntity(authorization),
			String.class,
			""
		);
	}

	@Override
	public HttpStatus deleteUser(String authorization, String id) {
		try {
			restTemplate.exchange(
				baseUri + "/" + id,
				HttpMethod.DELETE,
				getHttpEntity(authorization),
				Void.class
			);
			return HttpStatus.OK;
		} catch (Exception ignored) {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public ResponseEntity<UserRepresentation> createUser(String authorization, UserDTO userDTO) {
		try {
			return restTemplate.exchange(
				baseUri,
				HttpMethod.POST,
				getHttpEntity(authorization, userDTO),
				UserRepresentation.class
			);
		}catch (Exception ignored){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<UserRepresentation> updateUser(String authorization, UserDTO userDTO, String id) {
		try {
			return new ResponseEntity<>(restTemplate.exchange(
				baseUri + "/" + id,
				HttpMethod.PUT,
				getHttpEntity(authorization, userDTO),
				UserRepresentation.class
			).getBody(),HttpStatus.OK);
		}catch (Exception ignored){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<UserRepresentation> updateUserPassword(String authorization, UserDTO userDTO, String id) {
		try {
			return new ResponseEntity<>(restTemplate.exchange(
				baseUri + "/" + id,
				HttpMethod.PUT,
				getHttpEntity(authorization, userDTO),
				UserRepresentation.class
			).getBody(),HttpStatus.OK);
		}catch (Exception ignored){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}


	}

	private CredentialRepresentation credentialRepresentation(UserDTO userDTO) {
		CredentialRepresentation password = new CredentialRepresentation();
		password.setTemporary(false);
		password.setType(CredentialRepresentation.PASSWORD);
		password.setValue(userDTO.getPassword());
		return password;
	}

	private UserRepresentation userRepresentation(UserDTO userDTO, CredentialRepresentation passwords){
		UserRepresentation user = new UserRepresentation();
		user.setEnabled(userDTO.getEnabled());
		user.setUsername(userDTO.getUsername());
		user.setFirstName(userDTO.getFirstname());
		user.setLastName(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());
		user.setCredentials(List.of(passwords));
		return user;
	}

	private HttpEntity getHttpEntity(String authorization) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", authorization);
		return new HttpEntity<>(headers);
	}

	private HttpEntity getHttpEntity(String authorization, UserDTO userDTO) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", authorization);
		return new HttpEntity<>(userRepresentation(userDTO, credentialRepresentation(userDTO)),headers);
	}

}
