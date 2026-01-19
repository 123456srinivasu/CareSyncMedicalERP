package com.medical.caresync.repository;

import com.medical.caresync.entities.CampPurchaseOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampPurchaseOrderLineRepository extends JpaRepository<CampPurchaseOrderLine, Long> {

    @Query("""
            SELECT cpol
            FROM CampPurchaseOrderLine cpol
            WHERE cpol.purchaseOrder.purchaseOrderId = :purchaseOrderId
            """)
    List<CampPurchaseOrderLine> findByPurchaseOrderId(@Param("purchaseOrderId") Long purchaseOrderId);
}
