package com.trim.security.controller;

import com.trim.domain.member.dto.MemberRequest;
import com.trim.domain.member.dto.MemberRequest.MemberRegisterDto;
import com.trim.domain.member.service.MemberCommandService;
import com.trim.exception.payload.code.ErrorStatus;
import com.trim.exception.payload.dto.ApiResponseDto;
import com.trim.security.dto.JwtToken;
import com.trim.security.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@Tag(name = "Token API", description = "토큰 API")      TODO setting swagger
//@ApiResponse(responseCode = "2000", description = "성공")
@RequiredArgsConstructor
@RequestMapping("/api/tokens")
@RestController
public class TokenApiController {
    private final MemberCommandService memberCommandService;
    private final TokenService tokenService;

    @PostMapping("/sign-up")            //test용
    public ApiResponseDto<Long> signUp(@RequestBody MemberRegisterDto memberRegisterDto) {
        return ApiResponseDto.onSuccess(memberCommandService.signUp(memberRegisterDto));
    }
//    @Operation(summary = "로그인(토큰 생성)", description = "username을 통해 로그인합니다.")
//    @ApiErrorCodeExample({
//            ErrorStatus.MEMBER_NOT_FOUND
//    })
    @GetMapping("/login/{memberId}")       //test용
    public ApiResponseDto<JwtToken> login(@PathVariable Long memberId) {
        return ApiResponseDto.onSuccess(tokenService.login(memberId));
    }

//    @Operation(summary = "토큰 재발행", description = "리프레시 토큰을 통해 토큰을 재발행 받습니다.")
//    @ApiErrorCodeExample({
//            ErrorStatus.MEMBER_NOT_FOUND
//    })
    @PostMapping("/reissue")
    public ApiResponseDto<JwtToken> issueToken(@RequestParam String refresh) {
        return ApiResponseDto.onSuccess(tokenService.issueTokens(refresh));
    }
}
