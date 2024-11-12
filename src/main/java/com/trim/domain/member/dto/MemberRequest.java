package com.trim.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MemberRequest {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberRegisterDto{
        private String nickname;
    }
}
