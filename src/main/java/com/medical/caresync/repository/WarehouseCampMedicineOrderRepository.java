package com.medical.caresync.repository;

import com.medical.caresync.entities.WarehouseCampMedicineOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseCampMedicineOrderRepository extends JpaRepository<WarehouseCampMedicineOrder, Long> {
    Optional<WarehouseCampMedicineOrder> findByWarehouseCampOrderNumber(String warehouseCampOrderNumber);
}
