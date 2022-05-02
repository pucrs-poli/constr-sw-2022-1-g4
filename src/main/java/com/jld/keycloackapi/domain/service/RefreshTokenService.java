package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.application.data.RefreshTokenRequestBody;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;

public interface RefreshTokenService {

    ResponseEntity<AccessTokenResponse> refreshToken(RefreshTokenRequestBody refreshTokenRequestBody);

}
