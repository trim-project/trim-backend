package com.trim.global.auth.handler;

import com.trim.domain.member.entity.Role;
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

    private final String REDIRECT_URI = "localhost/"; // todo redirect uri 작성
    private final TokenService tokenService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (response.isCommitted()) {
            return;
        }
        log.info("--------------------------- OAuth2LoginSuccessHandler ---------------------------");
        JwtToken jwtToken = tokenService.generateToken(authentication);
        String provider = null;
//        boolean isGuest = false;

        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken oauth2Token = (OAuth2AuthenticationToken) authentication;
            provider = oauth2Token.getAuthorizedClientRegistrationId();
            Collection<GrantedAuthority> authorities = oauth2Token.getAuthorities();
            authorities.forEach(grantedAuthority -> log.info("role {}", grantedAuthority.getAuthority()));
//            isGuest = authorities.stream()
//                    .map(GrantedAuthority::getAuthority)
//                    .anyMatch(Role.GUEST.getKey()::equals);
        }

        //todo cookie refresh token 구현

        String url = UriComponentsBuilder.fromHttpUrl(REDIRECT_URI)
                .queryParam("code", jwtToken.getAccessToken())
                .queryParam("provider", provider)
//                .queryParam("isGuest", isGuest)
                .build()
                .toUriString();

        response.sendRedirect(url);

    }
}
