package com.jld.keycloackapi.domain.service;

import com.jld.keycloackapi.application.data.RefreshTokenRequestBody;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
@Service
public class RefreshTokenServiceImpl implements RefreshTokenService{
    private RestTemplate restTemplate = new RestTemplate();
    private String baseUri;

    public RefreshTokenServiceImpl(@Value("${baseLoginUri}") String baseUri) {
        this.baseUri = baseUri;
    }

    @Override
    public ResponseEntity<AccessTokenResponse> refreshToken(RefreshTokenRequestBody refreshTokenRequestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        MultiValueMap<String,String> form = new LinkedMultiValueMap<>();
        form.add("client_id",refreshTokenRequestBody.getClient_id());
        form.add("grant_type",refreshTokenRequestBody.getGrant_type());
        form.add("client_secret",refreshTokenRequestBody.getClient_secret());
        form.add("refresh_token",refreshTokenRequestBody.getRefresh_token());

        HttpEntity entity = new HttpEntity(form,headers);
        String url = new StringBuilder().append(baseUri).append("/protocol/openid-connect/token").toString();

        return restTemplate.postForEntity(
                url,
                entity, AccessTokenResponse.class
        );
    }
}
