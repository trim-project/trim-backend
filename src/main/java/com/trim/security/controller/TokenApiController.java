package com.trim.security.controller;

import com.trim.domain.member.dto.MemberRequest;
import com.trim.domain.member.dto.MemberRequest.MemberRegisterDto;
import com.trim.domain.member.service.MemberCommandService;
import com.trim.exception.payload.code.ErrorStatus;
import com.trim.exception.payload.dto.ApiResponseDto;
import com.trim.global.annotation.api.ApiErrorCodeExample;
import com.trim.security.dto.JwtToken;
import com.trim.security.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.trim.exception.payload.code.ErrorStatus.MEMBER_NOT_FOUND;

@Tag(name = "Token API", description = "토큰 API")
@ApiResponse(responseCode = "2000", description = "성공")
@RequiredArgsConstructor
@RequestMapping("/api/tokens")
@RestController
public class TokenApiController {
    private final MemberCommandService memberCommandService;
    private final TokenService tokenService;

    @Operation(summary = "회원가입(임시)", description = "서버 내 자체 테스트 회원가입입니다.")
    @ApiErrorCodeExample
    @PostMapping("/sign-up")            //test용
    public ApiResponseDto<Long> signUp(@RequestBody MemberRegisterDto memberRegisterDto) {
        return ApiResponseDto.onSuccess(memberCommandService.signUp(memberRegisterDto));
    }

    @Operation(summary = "로그인 (임시)", description = "서버 내 자체 테스트 회원가입입니다.")
    @ApiErrorCodeExample({
            MEMBER_NOT_FOUND
    })
    @GetMapping("/login/{memberId}")       //test용
    public ApiResponseDto<JwtToken> login(@PathVariable Long memberId) {
        return ApiResponseDto.onSuccess(tokenService.login(memberId));
    }

    @Operation(summary = "토큰 재발행", description = "리프레시 토큰을 통해 토큰을 재발행 받습니다.")
    @ApiErrorCodeExample({
            MEMBER_NOT_FOUND
    })
    @PostMapping("/reissue")
    public ApiResponseDto<JwtToken> issueToken(@RequestParam String refresh) {
        return ApiResponseDto.onSuccess(tokenService.issueTokens(refresh));
    }
}
