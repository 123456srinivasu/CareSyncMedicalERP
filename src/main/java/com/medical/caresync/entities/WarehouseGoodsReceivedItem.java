package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "warehouse_goods_received_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseGoodsReceivedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_goods_received_item_id")
    private Long warehouseGoodsReceivedItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_goods_received_id", nullable = false)
    private WarehouseGoodsReceived warehouseGoodsReceived;

    @Column(name = "medication_id")
    private Long medicationId;

    @Column(name = "medication_name")
    private String medicationName;

    @Column(name = "batch_number")
    private String batchNumber;

    @Column(name = "mfg_date")
    private Date mfgDate;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "storage_type")
    private String storageType;

    @Column(name = "ordered_qty")
    private Integer orderedQty;

    @Column(name = "received_qty")
    private Integer receivedQty;

    @Column(name = "damaged_qty")
    private Integer damagedQty;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "mrp")
    private BigDecimal mrp;

    @Column(name = "qc_status")
    private String qcStatus;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "created_by", length = 150)
    private String createdBy;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "updated_by", length = 150)
    private String updatedBy;
}
