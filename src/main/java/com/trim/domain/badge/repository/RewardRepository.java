package com.trim.domain.badge.repository;

import com.trim.domain.badge.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<Reward, Long> {
}
