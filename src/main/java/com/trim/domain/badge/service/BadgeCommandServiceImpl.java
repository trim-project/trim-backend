package com.trim.domain.badge.service;

import com.trim.domain.badge.dto.BadgeRequestDto;
import com.trim.domain.badge.repository.BadgeRepository;
import com.trim.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BadgeCommandServiceImpl implements BadgeCommandService{
    private final BadgeRepository badgeRepository;

    @Override
    public Long createBadge(Member member, BadgeRequestDto badgeRequestDto) {
        return 0;
    }

    @Override
    public Long editBadgeInfo(Member member, Long badgeId, BadgeRequestDto badgeRequestDto) {
        return 0;
    }

    @Override
    public void removeBadge(Member member, Long badgeId) {

    }

    @Override
    public Long completeMission(Member member, Long BadgeId) {
        return 0;
    }
}
