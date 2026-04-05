package com.medical.caresync.repository;

import com.medical.caresync.entities.WarehouseCampMedicineOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseCampMedicineOrderItemRepository extends JpaRepository<WarehouseCampMedicineOrderItem, Long> {
    List<WarehouseCampMedicineOrderItem> findByWarehouseCampMedicineOrderWarehouseCampMedicineOrderId(Long orderId);
}
