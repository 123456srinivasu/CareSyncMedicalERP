package com.medical.caresync.repository;

import com.medical.caresync.entities.WarehouseMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseMasterRepository extends JpaRepository<WarehouseMaster, Long> {
    Optional<WarehouseMaster> findByWarehouseCode(String warehouseCode);
}
