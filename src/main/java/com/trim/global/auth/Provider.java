package com.trim.global.auth;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Provider {
    GOOGLE("google"),
    KAKAO("kakao"),
    NAVER("naver");

    private final String registrationId;
    private static final String UNSUPPORTED_SOCIAL_LOGIN_MESSAGE = "지원하지 않는 소셜 로그인입니다.";

    Provider(String registrationId) {
        this.registrationId = registrationId;
    }

    public static Provider fromRegistrationId(String registrationId) {
        return Arrays.stream(values())
                .filter(provider -> provider.registrationId.equalsIgnoreCase(registrationId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(UNSUPPORTED_SOCIAL_LOGIN_MESSAGE));
    }
}