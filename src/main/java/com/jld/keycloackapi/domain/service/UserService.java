package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.configuration.KeycloakManager;
import com.jld.keycloackapi.domain.data.UserEntity;
import com.jld.keycloackapi.domain.dto.UserDTO;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService implements IUserService {
	@Autowired
	private Keycloak keycloak;

	@Value("${keycloak.realm}")
	private String realm;

	@Override
	public UserEntity getUser(String id) {
		return (UserEntity) keycloak.realm(realm).users().get(id);
	}

	@Override
	public List<UserRepresentation> getAllUsers() {
		return keycloak.realm(realm).users().list();
	}

	@Override
	public boolean createUser(UserDTO userDTO) {

		UserRepresentation user = userRepresentation(userDTO, credentialRepresentation(userDTO));

		try{
			keycloak.realm(realm).users().create(user);
			return true;
		}catch (Exception ignored){
			return false;
		}
	}

	@Override
	public boolean deleteUser(String id) {
		try{
			keycloak.realm(realm).users().delete(id);
			return true;
		}catch (Exception ignored){
			return false;
		}
	}

	@Override
	public boolean updateUser(UserDTO userDTO, String id) {

		UserRepresentation user = userRepresentation(userDTO, credentialRepresentation(userDTO));
		try{
			keycloak.realm(realm).users().get(id).update(user);
			return true;
		}catch (Exception ignored){
			return false;
		}
	}

	@Override
	public boolean updateUserPassword(UserDTO userDTO, String id) {

		UserRepresentation user = userRepresentation(userDTO, credentialRepresentation(userDTO));
		try{
			keycloak.realm(realm).users().get(id).update(user);
			return true;
		}catch (Exception ignored){
			return false;
		}
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
