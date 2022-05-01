package com.jld.keycloackapi.application.data;

public class LoginResponseBody {

	private final String token_type;
	private final String access_token;
	private final String expires_in;
	private final String refresh_token;
	private final String referesh_expires_in;

	public LoginResponseBody(String token_type, String access_token, String expires_in, String refresh_token, String referesh_expires_in) {
		this.token_type = token_type;
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.refresh_token = refresh_token;
		this.referesh_expires_in = referesh_expires_in;
	}

	public String getToken_type() {
		return token_type;
	}

	public String getAccess_token() {
		return access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public String getReferesh_expires_in() {
		return referesh_expires_in;
	}
}
