package com.trim.infra.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService{
    private final RedisTemplate redisTemplate;

    @Override
    public void setValueOfToken(String token, String username) {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set(token, username, Duration.ofDays(7));
    }

    @Override
    public String getValueOfToken(String token) {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        return values.get(token);
    }

    @Override
    public void deleteToken(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            // "Bearer " 접두사 제거
            token = token.substring(7);
        }
        redisTemplate.delete(token);
    }
}
