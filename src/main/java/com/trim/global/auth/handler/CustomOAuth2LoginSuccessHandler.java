package com.trim.global.auth.handler;

import com.trim.exception.payload.code.ErrorStatus;
import com.trim.exception.payload.exception.security.JwtAuthenticationException;
import com.trim.security.dto.JwtToken;
import com.trim.security.service.TokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Collection;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomOAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final String REDIRECT_URI = "http://localhost:8080/"; // todo redirect uri 작성
    private final TokenService tokenService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (response.isCommitted()) {
            return;
        }
        log.info("--------------------------- OAuth2LoginSuccessHandler ---------------------------");
        JwtToken jwtToken = tokenService.generateToken(authentication);
        
        // 인증 객체 검증
        validateOAuth2Authentication(authentication);

        OAuth2AuthenticationToken oauth2Token = (OAuth2AuthenticationToken) authentication;
        String provider = oauth2Token.getAuthorizedClientRegistrationId();
        Collection<GrantedAuthority> authorities = oauth2Token.getAuthorities();
        authorities.forEach(grantedAuthority -> log.info("role {}", grantedAuthority.getAuthority()));


        String url = UriComponentsBuilder.fromHttpUrl(REDIRECT_URI)
                .queryParam("provider", provider)
                .build()
                .toUriString();

        response.addHeader("Authorization",
                jwtToken.getGrantType() + " " + jwtToken.getAccessToken());

        response.sendRedirect(url);

    }
    private void validateOAuth2Authentication(Authentication authentication) {
        if (!(authentication instanceof OAuth2AuthenticationToken)){
            log.info("Invalid Authentication.");
            throw new JwtAuthenticationException(ErrorStatus.AUTH_INVALID_AUTHENTICATION);
        }
    }
}
