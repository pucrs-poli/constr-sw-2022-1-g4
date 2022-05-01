package com.jld.keycloackapi.application.data;

import static java.util.Objects.isNull;

public class LoginRequestBody {

	private final String client_id;
	private final String username;
	private final String password;

	private final String grant_type;

	public LoginRequestBody(final String client_id, final String username, final String password, final String grant_type) {
		this.client_id = client_id;
		this.username = username;
		this.password = password;
		this.grant_type = grant_type;
	}

	public boolean isValid() {
		return !isNull(client_id) && !isNull(username) && !isNull(password) && grant_type.equals("password");
	}

	public String getClient_id() {
		return client_id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getGrant_type() {
		return grant_type;
	}
}
