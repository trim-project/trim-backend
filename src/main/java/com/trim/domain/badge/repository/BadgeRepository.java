package com.trim.domain.badge.repository;

import com.trim.domain.badge.entity.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
}
