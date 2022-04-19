package com.jld.keycloackapi.domain.repository;


import com.jld.keycloackapi.domain.data.User;
import java.util.stream.Stream;

public interface UserRepository {

	User getUser();

	Stream<User> getAllUsers();

	boolean createUser();

	boolean deleteUser();

	boolean updateUser();

	boolean updateUserPassword();

}
