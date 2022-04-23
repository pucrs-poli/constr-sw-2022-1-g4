package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.domain.data.UserEntity;
import java.util.stream.Stream;

public class UserService implements IUserService {

	@Override
	public UserEntity getUser() {
		return null;
	}

	@Override
	public Stream<UserEntity> getAllUsers() {
		return null;
	}

	@Override
	public boolean createUser() {
		return false;
	}

	@Override
	public boolean deleteUser() {
		return false;
	}

	@Override
	public boolean updateUser() {
		return false;
	}

	@Override
	public boolean updateUserPassword() {
		return false;
	}
}
