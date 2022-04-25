package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.domain.dto.UserDTO;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements IUserService {

	@Value("${keycloak.auth-server-url}")
	String baseUri;

	@Value("${keycloak.realm}")
	String realm;

	private final RestTemplate restTemplate = new RestTemplate();

	private static final String PATH = "http://localhost:8080/auth/admin/realms/oauth2-demo-realm/users/";


	@Override
	public ResponseEntity<String> getUser(final String authorization, final String id) {
		return restTemplate.exchange(
			PATH + id,
			HttpMethod.GET,
			getHttpEntity(authorization),
			String.class
		);
	}

	@Override
	public ResponseEntity<String> getAllUsers(final String authorization) {
		return restTemplate.exchange(
			PATH,
			HttpMethod.GET,
			getHttpEntity(authorization),
			String.class,
			""
		);
	}

	@Override
	public HttpStatus deleteUser(final String authorization, final String id) {
		try {
			restTemplate.exchange(
				PATH + id,
				HttpMethod.DELETE,
				getHttpEntity(authorization),
				Void.class
			);
			return HttpStatus.OK;
		} catch (Exception ignored) {
			return HttpStatus.BAD_REQUEST;

		}

	}

	@Override
	public ResponseEntity<UserRepresentation> createUser(final String authorization, final UserDTO userDTO) {
		return restTemplate.exchange(
			PATH,
			HttpMethod.POST,
			getHttpEntity(authorization, userDTO),
			UserRepresentation.class
		);
	}

	@Override
	public ResponseEntity<UserRepresentation> updateUser(final String authorization, final UserDTO userDTO, final String id) {
		return restTemplate.exchange(
			PATH + id,
			HttpMethod.PUT,
			getHttpEntity(authorization, userDTO),
			UserRepresentation.class
		);
	}

	@Override
	public ResponseEntity<UserRepresentation> updateUserPassword(final String authorization, final UserDTO userDTO, final String id) {
		return restTemplate.exchange(
			PATH + id,
			HttpMethod.PUT,
			getHttpEntity(authorization, userDTO),
			UserRepresentation.class
		);
	}

	private CredentialRepresentation credentialRepresentation(final UserDTO userDTO) {
		CredentialRepresentation password = new CredentialRepresentation();
		password.setTemporary(false);
		password.setType(CredentialRepresentation.PASSWORD);
		password.setValue(userDTO.getPassword());
		return password;
	}

	private UserRepresentation userRepresentation(final UserDTO userDTO, final CredentialRepresentation passwords){
		UserRepresentation user = new UserRepresentation();
		user.setEnabled(true);
		user.setUsername(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstname());
		user.setLastName(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());
		user.setCredentials(List.of(passwords));
		return user;
	}

	private HttpEntity getHttpEntity(final String authorization) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", authorization);
		return new HttpEntity<>(headers);
	}

	private HttpEntity getHttpEntity(final String authorization, final UserDTO userDTO) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", authorization);
		return new HttpEntity<>(userRepresentation(userDTO, credentialRepresentation(userDTO)),headers);
	}

}
