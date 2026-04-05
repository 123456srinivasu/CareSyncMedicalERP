package com.medical.caresync.repository;

import com.medical.caresync.entities.WarehouseMedicineStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface WarehouseMedicineStockRepository extends JpaRepository<WarehouseMedicineStock, Long> {
    Optional<WarehouseMedicineStock> findByWarehouseIdAndMedicationIdAndBatchNumber(Long warehouseId, Long medicationId, String batchNumber);
    List<WarehouseMedicineStock> findByWarehouseId(Long warehouseId);
}
