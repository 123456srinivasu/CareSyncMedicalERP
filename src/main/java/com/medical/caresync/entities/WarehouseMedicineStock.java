package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "warehouse_medicine_stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseMedicineStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_medicine_stock_id")
    private Long warehouseMedicineStockId;

    @Column(name = "medication_id", nullable = false)
    private Long medicationId;

    @Column(name = "warehouse_id", nullable = false)
    private Long warehouseId;

    @Column(name = "pharmacy_supplier_id", nullable = false)
    private Long pharmacySupplierId;

    @Column(name = "batch_number", length = 100, nullable = false)
    private String batchNumber;

    @Column(name = "mfg_date")
    private Date mfgDate;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "mrp")
    private BigDecimal mrp;

    @Column(name = "created_by", length = 150)
    private String createdBy;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_by", length = 150)
    private String updatedBy;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
}
