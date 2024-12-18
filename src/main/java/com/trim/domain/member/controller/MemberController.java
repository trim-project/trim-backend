package com.trim.domain.member.controller;

import com.trim.domain.member.dto.MemberResponse;
import com.trim.domain.member.entity.Member;
import com.trim.exception.payload.dto.ApiResponseDto;
import com.trim.security.aop.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    /**
     *
     * 현재 로그인 중인 유저 정보 테스트
     */
    @GetMapping("/info")
    public ApiResponseDto<?> currentUserInfo(@CurrentUser Member member){
        MemberResponse dto = MemberResponse.builder()
                .id(member.getId())
                .username(member.getUsername())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .nicknameChangeChance(member.getNicknameChangeChance())
                .build();
        return ApiResponseDto.onSuccess(dto);
    }


}
