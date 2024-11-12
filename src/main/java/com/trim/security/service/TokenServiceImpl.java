package com.trim.security.service;

import com.trim.domain.member.service.MemberService;
import com.trim.infra.service.RedisService;
import com.trim.security.dto.JwtToken;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;

@Slf4j
@Service
public class TokenServiceImpl implements TokenService{
    private final Key key;      //security yml 파일 생성 후 app.jwt.secret에 값 넣어주기(보안을 위해 따로 연락주세요)
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RedisService redisService;
    private final MemberService memberService;

    public TokenServiceImpl(@Value("${app.jwt.secret}") String key,
                            AuthenticationManagerBuilder authenticationManagerBuilder,
                            RedisService redisService,
                            MemberService memberService) {
        byte[] keyBytes = Decoders.BASE64.decode(key);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.redisService = redisService;
        this.memberService = memberService;
    }

    @Override
    public JwtToken login(String kakaoEmail) {
        return null;
    }

    @Override
    public JwtToken issueTokens(String refreshToken) {
        return null;
    }

    @Override
    public JwtToken generateToken(Authentication authentication) {
        return null;
    }

    @Override
    public Authentication getAuthentication(String accessToken) {
        return null;
    }

    @Override
    public boolean validateToken(String token) {
        return false;
    }

    @Override
    public boolean logout(String refreshToken) {
        return false;
    }

    @Override
    public boolean existsRefreshToken(String refreshToken) {
        return false;
    }
}
