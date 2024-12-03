package com.trim.domain.member.controller;

import com.trim.domain.member.entity.Member;
import com.trim.exception.payload.dto.ApiResponseDto;
import com.trim.security.aop.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    /**
     *
     * 현재 로그인 중인 유저 정보 테스트
     */
    public ApiResponseDto<?> currentUserInfo(@CurrentUser Member member){
        return ApiResponseDto.onSuccess(member);
    }


}
