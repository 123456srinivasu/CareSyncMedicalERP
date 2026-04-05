package com.medical.caresync.repository;

import com.medical.caresync.entities.WarehouseCampMedicineSentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseCampMedicineSentItemRepository extends JpaRepository<WarehouseCampMedicineSentItem, Long> {
    List<WarehouseCampMedicineSentItem> findByWarehouseCampMedicineSentWarehouseCampMedicineSentId(Long sentId);
}
