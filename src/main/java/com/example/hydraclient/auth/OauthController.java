package com.example.hydraclient.auth;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("token")
@RequiredArgsConstructor
public class OauthController {

    @NonNull final OAuthService oAuthService;



    @GetMapping("code")
    public ResponseEntity<CodeExchangeResponse> exchangeCode(@RequestParam String code) {
        return ResponseEntity.ok(oAuthService.exchangeCode(code));
    }

    @GetMapping("refresh")
    public ResponseEntity<CodeExchangeResponse> reissueToken(@RequestParam String token) {
        return ResponseEntity.ok(oAuthService.reissueToken(token));
    }

    @GetMapping("logout")
    public ResponseEntity<?> redirectLogout() {
        return ResponseEntity.ok("success logout");
    }


}
