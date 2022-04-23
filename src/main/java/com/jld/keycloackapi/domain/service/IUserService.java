package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.domain.data.UserEntity;

import java.util.stream.Stream;

public interface IUserService {

    UserEntity getUser();

    Stream<UserEntity> getAllUsers();

    boolean createUser();

    boolean deleteUser();

    boolean updateUser();

    boolean updateUserPassword();
}
