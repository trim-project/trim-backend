package com.trim.domain.member.repository;

import com.trim.domain.member.entity.Member;
import com.trim.domain.member.repository.querydsl.MemberQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberQueryRepository {
    Optional<Member> findByUsername(String username);
}
