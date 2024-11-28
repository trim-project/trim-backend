package com.trim.domain.badge.service;

import com.trim.domain.badge.entity.Badge;
import com.trim.domain.badge.repository.BadgeRepository;
import com.trim.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BadgeQueryServiceImpl implements BadgeQueryService{

    private final BadgeRepository badgeRepository;

    @Override
    public List<Badge> getAllBadges() {
        return List.of();
    }

    @Override
    public List<Badge> getRewardedBadges(Member member) {
        return List.of();
    }

    @Override
    public List<Badge> getBadgesInProgress(Member member) {
        return List.of();
    }
}
