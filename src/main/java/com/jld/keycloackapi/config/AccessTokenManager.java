package com.jld.keycloackapi.config;

import com.jld.keycloackapi.application.data.RefreshTokenRequestBody;
import com.jld.keycloackapi.domain.service.RefreshTokenServiceImpl;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;

@Configuration
public class AccessTokenManager extends Thread {

    @Resource
    private RefreshTokenServiceImpl tokenService;


    public boolean logged;
    private long expires_in;
    private String refreshToken;

    private final String client_id;
    private String client_secret;
    private String grant_type;

    public AccessTokenManager(@Value("${keycloak.resource}") String client_id){
        this.client_id = client_id;
        this.grant_type ="refresh_token";
    }

    public void add(String refreshToken, long expires_in, String client_secret){
        this.logged = false;
        this.refreshToken =refreshToken;
        this.expires_in = expires_in;
        this.client_secret = client_secret;
    }

    @Override
    public void run() {
        while (logged){
            try {
                Thread.sleep(expires_in);
                ResponseEntity<AccessTokenResponse> responseEntity = tokenService.refreshToken(new RefreshTokenRequestBody(client_id, grant_type, client_secret, refreshToken));
                refreshToken = responseEntity.getBody().getRefreshToken();
                expires_in = responseEntity.getBody().getExpiresIn();
                System.out.println("New Access Token:" + responseEntity.getBody().getToken());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
