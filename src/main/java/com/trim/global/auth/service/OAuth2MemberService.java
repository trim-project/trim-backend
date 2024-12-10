package com.trim.global.auth.service;

import com.trim.domain.member.entity.Member;
import com.trim.domain.member.entity.Role;
import com.trim.domain.member.entity.SocialType;
import com.trim.domain.member.repository.MemberRepository;
import com.trim.global.auth.dto.OAuth2UserInfo;
import com.trim.global.auth.utils.OAuth2Utils;
import com.trim.global.auth.utils.RandomStringGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OAuth2MemberService {

    private final String TEMP_NICKNAME_HEADER = "TRIM_";
    private final int TEMP_NICKNAME_LENGTH = 10;

    private final MemberRepository memberRepository;

    public Member generateMemberFromOAuthUserInfo(OAuth2UserInfo oauth2UserInfo, SocialType socialType){
        // 값 추출
        String socialId = oauth2UserInfo.getSocialId();
        String email = oauth2UserInfo.getEmail();
        String username = OAuth2Utils.generateUsername(socialType.getKey(), socialId);

        Optional<Member> targetMember = memberRepository.findByUsername(username);
        Member member = targetMember.orElseGet(() -> signupSocialMember(username, email, socialType));

        return member;
    }

    private Member signupSocialMember(String username, String email, SocialType socialType) {
        String nickname = TEMP_NICKNAME_HEADER +
                generateUniqueNickname(TEMP_NICKNAME_LENGTH);

        Member member = Member.builder()
                .username(username)
                .nickname(nickname)
                .nicknameChangeChance(1)
                .email(email)
                .socialType(socialType)
                .role(Role.USER)
                .build();
        return memberRepository.save(member);
    }

    private String generateUniqueNickname(int length) {
        String nickname;

        do {
            nickname = RandomStringGenerator.generateRandomString(length);
        } while (memberRepository.existsByNickname(nickname));

        return nickname;
    }

}
