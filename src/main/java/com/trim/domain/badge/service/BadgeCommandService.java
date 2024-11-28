package com.trim.domain.badge.service;

import com.trim.domain.badge.dto.BadgeRequestDto;
import com.trim.domain.member.entity.Member;

public interface BadgeCommandService {

    //admin
    Long createBadge(Member member, BadgeRequestDto badgeRequestDto);

    Long editBadgeInfo(Member member, Long badgeId, BadgeRequestDto badgeRequestDto);

    void removeBadge(Member member, Long badgeId);

    //user
    Long completeMission(Member member, Long BadgeId);

}
