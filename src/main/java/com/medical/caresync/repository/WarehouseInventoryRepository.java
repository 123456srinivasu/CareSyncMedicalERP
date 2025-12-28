package com.medical.caresync.repository;

import com.medical.caresync.entities.WarehouseInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseInventoryRepository extends JpaRepository<WarehouseInventory, Long> {
}
