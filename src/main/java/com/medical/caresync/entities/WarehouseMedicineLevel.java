package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "warehouse_medicine_level")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseMedicineLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_medicine_level_id")
    private Long warehouseMedicineLevelId;

    @Column(name = "warehouse_id", nullable = false)
    private Long warehouseId;

    @Column(name = "medication_id", nullable = false)
    private Long medicationId;

    @Column(name = "pharmacy_supplier_id", nullable = false)
    private Long pharmacySupplierId;

    @Column(name = "min_stock_quantity")
    private Integer minStockQuantity;

    @Column(name = "max_stock_quantity")
    private Integer maxStockQuantity;

    @Column(name = "is_active")
    private Boolean isActive;

    // Audit Columns
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private java.sql.Date createdAt; // Use the type that matches your system

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
}
