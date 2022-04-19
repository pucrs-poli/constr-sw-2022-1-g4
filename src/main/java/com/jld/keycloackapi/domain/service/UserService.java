package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.domain.data.User;
import com.jld.keycloackapi.domain.repository.UserRepository;
import java.util.stream.Stream;

public class UserService implements UserRepository {

	@Override
	public User getUser() {
		return null;
	}

	@Override
	public Stream<User> getAllUsers() {
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
