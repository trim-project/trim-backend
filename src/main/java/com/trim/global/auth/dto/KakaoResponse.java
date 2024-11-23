package com.trim.global.auth.dto;

import java.util.Map;

public class KakaoResponse implements OAuth2Response{
    private final Map<String, Object> attribute;
    private final Map<String, Object> account;

    public KakaoResponse(Map<String, Object> attribute, Map<String, Object> account) {
        this.attribute = attribute;
        this.account = (Map<String, Object>) attribute.get("kakao_account");
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getProviderId() {
        return attribute.get("id").toString();
    }

    @Override
    public String getEmail() {
        return account.get("email").toString();
    }
}
