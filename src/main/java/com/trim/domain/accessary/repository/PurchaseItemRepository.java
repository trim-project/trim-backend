package com.trim.domain.accessary.repository;

import com.trim.domain.accessary.entity.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {
}
