package com.medical.caresync.repository;

import com.medical.caresync.entities.WarehouseGoodsReceived;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseGoodsReceivedRepository extends JpaRepository<WarehouseGoodsReceived, Long> {
    Optional<WarehouseGoodsReceived> findByWarehouseGoodsReceivedNumber(String number);
    List<WarehouseGoodsReceived> findByPurchaseOrderId(Long purchaseOrderId);
}
