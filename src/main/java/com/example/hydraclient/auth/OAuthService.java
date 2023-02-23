package com.example.hydraclient.auth;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OAuthService {
    @NonNull final OAuthApiClient oAuthApiClient;

    public CodeExchangeResponse exchangeCode(String code) {
        return oAuthApiClient.exchangeAuthorizationCodeForAccessCode(code);
    }
    public CodeExchangeResponse reissueToken(String token) {
        return oAuthApiClient.reissueToken(token);
    }
}
