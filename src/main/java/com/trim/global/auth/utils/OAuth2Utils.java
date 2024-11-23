package com.trim.global.auth.utils;

import com.trim.global.auth.Provider;
import com.trim.global.auth.dto.GoogleUserInfo;
import com.trim.global.auth.dto.KakaoUserInfo;
import com.trim.global.auth.dto.NaverUserInfo;

import java.util.Map;

public class OAuth2Utils {

    // registrationId에 따른 Provider 추출
    public static Provider getProvider(String registrationId){

        if(registrationId.equals("naver")){
            return Provider.NAVER;
        }
        else if(registrationId.equals("google")){
            return Provider.GOOGLE;
        }
        else if(registrationId.equals("kakao")){
            return Provider.KAKAO;
        }
        return null;
    }

    public static Object getObject(Provider provider, Map<String, Object> attributes){
        switch (provider){
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
