package com.trim.security.service;

import com.trim.security.dto.JwtToken;
import org.springframework.security.core.Authentication;

public interface TokenService {
    JwtToken login(String username);
    JwtToken issueTokens(String refreshToken);

    JwtToken generateToken(Authentication authentication);

    Authentication getAuthentication(String accessToken);

    boolean validateToken(String token);

    boolean logout(String refreshToken);

    boolean existsRefreshToken(String refreshToken);
}
