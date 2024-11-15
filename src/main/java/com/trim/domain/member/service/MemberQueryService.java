package com.trim.domain.member.service;

import com.trim.domain.member.entity.Member;

public interface MemberQueryService {
    Member getMemberInfoByUsername(String username);

    Member getMemberInfoById(Long memberId);
}
