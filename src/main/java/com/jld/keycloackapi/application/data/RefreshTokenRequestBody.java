package com.jld.keycloackapi.application.data;

public class RefreshTokenRequestBody {

    private final String client_id;
    private final String grant_type;
    private final String client_secret;
    private final String refresh_token;

    public RefreshTokenRequestBody(String client_id, String grant_type, String client_secret, String refresh_token) {
        this.client_id = client_id;
        this.grant_type = grant_type;
        this.client_secret = client_secret;
        this.refresh_token = refresh_token;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public String getClient_id() {
        return client_id;
    }
}
