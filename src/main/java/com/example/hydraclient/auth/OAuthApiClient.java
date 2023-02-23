package com.example.hydraclient.auth;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuthApiClient {
    @NonNull final WebClient webClient;

    @Value("${hydra.client-id}")
    private String clientId;
    @Value("${hydra.client-secret}")
    private String clientSecret;
    @Value("${hydra.redirect-uri}")
    private String redirectUri;
    @Value("${hydra.public-path}")
    private String publicPath;

    public CodeExchangeResponse exchangeAuthorizationCodeForAccessCode(String code) {
        Map<String, String> bodyMap = Map.of(
                "client_id", clientId,
                "code", code,
                "grant_type", GrantType.AUTHORIZATION_CODE.getCode(),
                "redirect_uri", redirectUri
        );

        return requestOauthToken(bodyMap);
    }

    public CodeExchangeResponse reissueToken(String token) {
        Map<String, String> bodyMap = Map.of(
                "client_id", clientId,
                "refresh_token", token,
                "grant_type", GrantType.REFRESH_TOKEN.getCode(),
                "redirect_uri", redirectUri
        );

        return requestOauthToken(bodyMap);
    }

    private CodeExchangeResponse requestOauthToken(Map<String, String> bodyMap) {
        String encodedParams = bodyMap.entrySet()
                                    .stream()
                                    .map(entry -> String.join("=",
                                            URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8),
                                            URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                                    ).collect(Collectors.joining("&"));

        return webClient.mutate()
                .build()
                .post()
                .uri(URI.create(publicPath + "/oauth2/token"))
                .header("authorization", "Basic "
                        + Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes()))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(encodedParams)
                .retrieve()
                .bodyToMono(CodeExchangeResponse.class)
                .block();
    }
}
