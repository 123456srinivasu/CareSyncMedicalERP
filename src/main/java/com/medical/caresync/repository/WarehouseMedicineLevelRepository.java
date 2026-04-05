package com.medical.caresync.repository;

import com.medical.caresync.entities.WarehouseMedicineLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseMedicineLevelRepository extends JpaRepository<WarehouseMedicineLevel, Long> {
    Optional<WarehouseMedicineLevel> findByWarehouseIdAndMedicationId(Long warehouseId, Long medicationId);
}
