package com.trim.security.service;

import com.trim.domain.member.service.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberQueryService memberQueryService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberQueryService.getMemberInfoByUsername(username);
    }
}
