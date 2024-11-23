package com.trim.global.auth.service;

import com.trim.domain.member.entity.Member;
import com.trim.domain.member.repository.MemberRepository;
import com.trim.domain.member.service.MemberQueryService;
import com.trim.domain.member.service.MemberQueryServiceImpl;
import com.trim.global.auth.CustomOAuthUser;
import com.trim.global.auth.Provider;
import com.trim.global.auth.dto.GoogleResponse;
import com.trim.global.auth.dto.KakaoResponse;
import com.trim.global.auth.dto.NaverResponse;
import com.trim.global.auth.dto.OAuth2Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberQueryService memberQueryService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        Provider provider

        OAuth2Response oAuth2Response = null;


        if(registrationId.equals("naver")){
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        }
        else if(registrationId.equals("google")){
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }
        else if(registrationId.equals("kakao")){
            oAuth2Response = new KakaoResponse(oAuth2User.getAttributes());
        }
        else{
            return null;
        }

        //todo UserDto 구현.. username 값은 어떻게?
        String username = "random"; //변경 예정
        Member targetMember = memberQueryService.getMemberInfoByUsername(username);

        //todo CustomOAuthUser 구현

        return new CustomOAuthUser();
    }
}
