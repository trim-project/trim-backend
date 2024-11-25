package com.trim.domain.accessary.repository;

import com.trim.domain.accessary.entity.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessoryRepository extends JpaRepository<Accessory, Long> {
}
