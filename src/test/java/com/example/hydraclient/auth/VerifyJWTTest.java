package com.example.hydraclient.auth;

import com.auth0.jwk.JwkException;
import com.auth0.jwt.interfaces.Claim;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.Map;


@Slf4j
@SpringBootTest
class VerifyJWTTest {

    @Autowired
    OAuthApiClient jwt;
    @Test
    void 토큰시그니처유효성테스트() throws JwkException {
        String token = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjQ4ZTViMzJiLTEyYWYtNDFhZS05ZmQ4LTdlOGQ5YzBkYjkzOSIsInR5cCI6IkpXVCJ9.eyJhdF9oYXNoIjoiUTlTamJNdDNWQnlwUjF5YnZYOVUxUSIsImF1ZCI6WyIxMjQyZmE3Ni0yYmE2LTQxZTMtOTIwNy1jMWVjYWQxOTI1ODQiXSwiYXV0aF90aW1lIjoxNjc4MDg2Mjg3LCJleHAiOjE2NzgwOTAwMDYsImlhdCI6MTY3ODA4NjQwNiwiaXNzIjoiaHR0cDovLzEyNy4wLjAuMTo0NDQ0IiwianRpIjoiZTZjYmU0ODMtMzI0YS00NzE4LTllOWItNjAyZDc5YzAxYzBhIiwicmF0IjoxNjc4MDg2NDAzLCJzaWQiOiI0ZTM1ZDFjOC0zNjBlLTRhYzYtYTg2MC1mN2E5MDZjYTdjYmUiLCJzdWIiOiI0ODU3NjcyIn0.ZrGQgvlxFxUSCbUqjuu2Liu0vcTeYWYu16eLotxRlCPz0MwNzG_goZ6dDSh8EMe_79mZ2ZjCojKaVhpKzrqiJlB-2k_d0cSUVhCIFi4rF6Egg-Umg-G1O-Gca2PgqF-XQ53OTBWVWcFfzKgLodvMFQIayFiDHUQ1D9CZH689Kx56FafLO4kJ4BWP9UUAl5k6D7h5s0LSASLXuEaVO7sQBspH0hWPpjxlUvMznuoHjxKT8A27pUMzTDboKjUUsKAwuu09XWOOdmf3Jwpi503BqVwYXQqVr-Zz1LJ5D9j8BBWcwxIvwfu67RMe8JCJ2L-A9giVLGCC_As1jzW7M_oMYAyTt09eebl_DD_yV39Z0lKJYvcYY6IQ9a2A8JpwNM0OUzAiUQ0Wkb5ixgsqxZv-xpwvXJ9I4KJ2QMEK3EnZqpCz88q2Tmk59FbY0ffmiu9oEFAsqFInMzaCqrJgUG8MDitVBNMydpDWd5BtaXFpeyTfl0XXj31yeVIOHG0_I11qSpZTn1SgiIbvWHC0xjafmVGGbrPYtgqVMwWzQehwy6OgOa8ZnffASzrgCLZyheu4eDj3p4Fw7p_dpevUbOVbVNhWLVC2uGp9ZEnRZ1NoyNp4_GwgHGOGriKrV-E3L9xJvds_2qGPvRl2NPHdnM2tDxZ3CAdvYzftKbD7BvBKrXA";
        jwt.verify(token);

        Map<String, Claim> claims = jwt.getClaims(token);

        Iterator<Map.Entry<String, Claim>> iterator = claims.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Claim> next = iterator.next();
            log.debug(String.valueOf(next.getValue()));
        }
    }
}