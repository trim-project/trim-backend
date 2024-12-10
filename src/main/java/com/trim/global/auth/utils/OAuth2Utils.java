package com.trim.global.auth.utils;

import com.trim.domain.member.entity.SocialType;
import com.trim.global.auth.dto.GoogleUserInfo;
import com.trim.global.auth.dto.KakaoUserInfo;
import com.trim.global.auth.dto.NaverUserInfo;
import com.trim.global.auth.dto.OAuth2UserInfo;

import java.util.Map;

public class OAuth2Utils {

    // registrationId에 따른 Provider 추출
    public static SocialType getSocialType(String registrationId){

        switch (registrationId){
            case "naver":
                return SocialType.NAVER;
            case "google":
                return SocialType.GOOGLE;
            case "kakao":
                return SocialType.KAKAO;
        }
        return null;
    }

    public static OAuth2UserInfo getOAuth2UserInfo(SocialType socialType, Map<String, Object> attributes){
        switch (socialType){
            case NAVER:
                return new NaverUserInfo(attributes);
            case GOOGLE:
                return new GoogleUserInfo(attributes);
            case KAKAO:
                return new KakaoUserInfo(attributes);
        }
        return null;
    }
}
