package com.trim.domain.member.service;

import com.trim.domain.member.dto.MemberRequest;
import com.trim.domain.member.dto.MemberRequest.MemberRegisterDto;

public interface MemberCommandService {

    Long signUp(MemberRegisterDto memberRegisterDto);
}
