package com.recipe.backend.domain.user.dto;

import lombok.Getter;

@Getter
public class LoginResponse {
    private String username;
    private String token;

    public LoginResponse(String username, String token) {
        this.username = username;
        this.token = token;
    }

}

