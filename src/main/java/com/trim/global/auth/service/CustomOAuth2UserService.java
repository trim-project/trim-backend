package com.trim.global.auth.service;

import com.trim.domain.member.entity.Member;
import com.trim.domain.member.entity.SocialType;
import com.trim.domain.member.service.MemberQueryService;
import com.trim.global.auth.CustomOAuthUser;
import com.trim.global.auth.dto.OAuth2UserInfo;
import com.trim.global.auth.utils.OAuth2Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberQueryService memberQueryService;

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

        OAuth2UserInfo oAuth2UserInfo = null;

        //todo UserDto 구현.. username 값은 어떻게?
        String username = "random"; //변경 예정
        Member targetMember = memberQueryService.getMemberInfoByUsername(username);

        //todo CustomOAuthUser 구현

        return new CustomOAuthUser();
    }
}
