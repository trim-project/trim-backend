package com.trim.exception.payload.exception.security;


import com.trim.exception.payload.code.ErrorStatus;
import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(ErrorStatus errorStatus){
        super(errorStatus.name());
    }
}
