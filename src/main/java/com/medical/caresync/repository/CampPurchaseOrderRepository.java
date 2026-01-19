package com.medical.caresync.repository;

import com.medical.caresync.entities.CampPurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampPurchaseOrderRepository extends JpaRepository<CampPurchaseOrder, Long> {

        @Query("""
                        SELECT cpo
                        FROM CampPurchaseOrder cpo
                        WHERE cpo.camp.campId = :campId
                        ORDER BY cpo.requestedAt DESC
                        """)
        List<CampPurchaseOrder> findByCampId(@Param("campId") Long campId);

        @Query("""
                        SELECT cpo
                        FROM CampPurchaseOrder cpo
                        WHERE cpo.pharmacySupplier.pharmacySupplierId = :supplierId
                        ORDER BY cpo.requestedAt DESC
                        """)
        List<CampPurchaseOrder> findBySupplierId(@Param("supplierId") Long supplierId);

        @Query("""
                        SELECT cpo
                        FROM CampPurchaseOrder cpo
                        WHERE cpo.orderStatus = :status
                        ORDER BY cpo.requestedAt DESC
                        """)
        List<CampPurchaseOrder> findByOrderStatus(@Param("status") String status);

        @Query("""
                        SELECT cpo
                        FROM CampPurchaseOrder cpo
                        WHERE cpo.pharmacySupplier.pharmacySupplierId = :supplierId
                        AND (:campId IS NULL OR cpo.camp.campId = :campId)
                        AND (:status IS NULL OR cpo.orderStatus = :status)
                        ORDER BY cpo.requestedAt DESC
                        """)
        List<CampPurchaseOrder> findBySupplierIdWithFilters(
                        @Param("supplierId") Long supplierId,
                        @Param("campId") Long campId,
                        @Param("status") String status);
}
