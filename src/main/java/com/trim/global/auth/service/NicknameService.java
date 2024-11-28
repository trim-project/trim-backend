package com.trim.global.auth.service;

import com.trim.domain.member.repository.MemberRepository;
import com.trim.global.auth.utils.RandomStringGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NicknameService {

    private final MemberRepository memberRepository;

    public String generateUniqueNickname(int length) {
        String nickname;

        do {
            nickname = RandomStringGenerator.generateRandomString(length);
        } while (memberRepository.findByNickname(nickname).isPresent());

        return nickname;
    }
}
