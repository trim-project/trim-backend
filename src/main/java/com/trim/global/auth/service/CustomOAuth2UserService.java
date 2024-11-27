package com.trim.global.auth.service;

import com.trim.domain.member.entity.Member;
import com.trim.domain.member.entity.Role;
import com.trim.domain.member.entity.SocialType;
import com.trim.domain.member.repository.MemberRepository;
import com.trim.domain.member.service.MemberQueryService;
import com.trim.global.auth.domain.CustomOAuthUser;
import com.trim.global.auth.domain.OAuth2Attributes;
import com.trim.global.auth.dto.OAuth2UserInfo;
import com.trim.global.auth.utils.OAuth2Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberQueryService memberQueryService;
    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();
        SocialType socialType = OAuth2Utils.getSocialType(registrationId);

        log.info("registrationId={}", registrationId);
        log.info("userNameAttributeName={}", userNameAttributeName);
        log.info("socialType={}", socialType);

        // 소셜에서 전달받은 정보를 가진 OAuth2User 에서 Map 을 추출하여 OAuth2Attribute 를 생성
        Map<String, Object> attributes = oAuth2User.getAttributes();

        // 내부에서 OAuth2UserInfo 생성과 함께 OAuth2Attributes 를 생성해서 반환
        OAuth2Attributes oauth2Attributes = OAuth2Attributes.of(socialType, userNameAttributeName, attributes);
        OAuth2UserInfo oauth2UserInfo = oauth2Attributes.getOAuth2UserInfo();

        // 값 추출
        String socialId = oauth2UserInfo.getSocialId();
        String email = oauth2UserInfo.getEmail();

        log.info("socialId={}", socialId);
        log.info("email={}", email);

        //todo UserDto 구현.. username 값은 어떻게? -> registrationId + " " + socialId 고려 중..
        String username = "random"; //변경 예정
        Optional<Member> targetMember = memberRepository.findByUsername(username);
        Member member = targetMember.orElseGet(() -> signupSocialMember(username, email, socialType));

        return new CustomOAuthUser(member,
                Collections.singleton(new SimpleGrantedAuthority(member.getRole().getKey())),
                attributes);
    }

    private Member signupSocialMember(String username, String email, SocialType socialType) {
        // 회원이 아닐 경우 Guest로 가입
        Member member = Member.builder()
                .username(username)
                .email(email)
                .socialType(socialType)
                .role(Role.GUEST)
                .build();
        return memberRepository.save(member);
    }
}
