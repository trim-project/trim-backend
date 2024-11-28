package com.trim.domain.badge.repository;

import com.trim.domain.badge.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
