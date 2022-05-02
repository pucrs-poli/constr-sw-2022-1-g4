package com.jld.keycloackapi.application.controllers;

import com.jld.keycloackapi.application.data.RefreshTokenRequestBody;
import com.jld.keycloackapi.domain.service.RefreshTokenServiceImpl;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/token")
public class RefreshTokenController {
    @Resource
    private RefreshTokenServiceImpl tokenService;

    @PostMapping()
    public ResponseEntity<AccessTokenResponse> token(@RequestBody RefreshTokenRequestBody body) {
        return tokenService.refreshToken(body);
    }
}
