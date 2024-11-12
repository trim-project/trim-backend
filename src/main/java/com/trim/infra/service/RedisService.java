package com.trim.infra.service;

public interface RedisService {

    void setValueOfToken(String token, String username);

    String getValueOfToken(String token);

    void deleteToken(String token);
}
