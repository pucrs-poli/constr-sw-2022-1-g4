package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.domain.data.UserEntity;
import com.jld.keycloackapi.domain.dto.UserDTO;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface IUserService {

    UserEntity getUser(String id);

    List<UserRepresentation> getAllUsers();

    boolean createUser(UserDTO userDTO);

    boolean deleteUser(String id);

    boolean updateUser(UserDTO userDTO, String id);

    boolean updateUserPassword(UserDTO userDTO, String id);
}
