package com.example.hydraclient.auth;

import lombok.Getter;

@Getter
public enum GrantType {
    AUTHORIZATION_CODE("authorization_code"),
    REFRESH_TOKEN("refresh_token"),
    CLIENT_CREDENTIALS("client_credentials");

    private String code;

    GrantType(String code) {
        this.code = code;
    }
}
