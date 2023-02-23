package com.example.hydraclient.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CodeExchangeResponse {
    @JsonProperty("access_token") String accessToken;
    @JsonProperty("expires_in") long expiresIn;
    @JsonProperty("id_token") String idToken;
    @JsonProperty("refresh_token") String refreshToken;
    @JsonProperty("scope") String scope;
    @JsonProperty("token_type") String tokenTyp;
}
