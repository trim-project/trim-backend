package com.trim.domain.badge.service;

import com.trim.domain.badge.entity.Badge;
import com.trim.domain.member.entity.Member;

import java.util.List;

public interface BadgeQueryService {

    List<Badge> getAllBadges();

    List<Badge> getRewardedBadges(Member member);

    List<Badge> getBadgesInProgress(Member member);
}
