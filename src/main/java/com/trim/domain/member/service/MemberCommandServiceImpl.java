package com.trim.domain.member.service;

import com.trim.domain.member.dto.MemberRequest;
import com.trim.domain.member.dto.MemberRequest.MemberRegisterDto;
import com.trim.domain.member.entity.Member;
import com.trim.domain.member.entity.Role;
import com.trim.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;

    @Override
    public Long signUp(MemberRegisterDto memberRegisterDto) {
        //TODO 실제 프로젝트에서는 사용하지 않을 메서드이기 때문에 지울 예정
        Member member = Member.builder()
                .nickname(memberRegisterDto.getNickname())
                .role(Role.USER)
                .build();

        memberRepository.save(member);
        return member.getId();
    }
}
