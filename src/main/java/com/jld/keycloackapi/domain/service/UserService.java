package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.domain.data.UserEntity;
import com.jld.keycloackapi.domain.dto.UserDTO;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;

@Service
public class UserService implements IUserService {
	@Autowired
	private Keycloak keycloak;

	@Value("${keycloak.realm}")
	private String realm;

	@Override
	public UserEntity getUser() {
		return null;
	}

	@Override
	public List<UserRepresentation> getAllUsers() {
		return keycloak.realm(realm).users().list();
	}

	@Override
	public boolean createUser(UserDTO userDTO) {
		keycloak.tokenManager().getAccessToken();
		UserRepresentation user = new UserRepresentation();
		user.setEnabled(true);
		user.setUsername(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstname());
		user.setLastName(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());

		RealmResource realmResource = keycloak.realm(realm);
		UsersResource usersRessource = realmResource.users();

		try{
			usersRessource.create(user);
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
//		try{
//			return true;
//		}catch (Exception ignored){
//			return false;
//		}
		return false;
	}

	@Override
	public boolean updateUserPassword() {
		return false;
	}
}
