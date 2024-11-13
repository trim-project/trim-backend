package com.trim.security.controller;

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
    private final TokenService tokenService;
//    @Operation(summary = "로그인(토큰 생성)", description = "username을 통해 로그인합니다.")
//    @ApiErrorCodeExample({
//            ErrorStatus.MEMBER_NOT_FOUND
//    })
    @GetMapping("/login")       //test용
    public ApiResponseDto<JwtToken> login(@RequestParam String kakaoEmail) {
        return ApiResponseDto.onSuccess(tokenService.login(kakaoEmail));
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
