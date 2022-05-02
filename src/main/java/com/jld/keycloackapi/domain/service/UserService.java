package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.domain.dto.UserDTO;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<String> getUser(String Authorization, String id);

    ResponseEntity<String> getAllUsers(String Authorization);

    ResponseEntity<String> createUser(String Authorization, UserDTO userDTO);

    HttpStatus deleteUser(String Authorization, String id);

    ResponseEntity<UserRepresentation> updateUser(String Authorization,UserDTO userDTO, String id);

    ResponseEntity<UserRepresentation> updateUserPassword(String Authorization,UserDTO userDTO, String id);

}
