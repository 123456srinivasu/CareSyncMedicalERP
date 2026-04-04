package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "warehouse_goods_received")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseGoodsReceived {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_goods_received_id")
    private Long warehouseGoodsReceivedId;

    @Column(name = "warehouse_goods_received_number", length = 50, nullable = false, unique = true)
    private String warehouseGoodsReceivedNumber;

    @Column(name = "purchase_order_id")
    private Long purchaseOrderId;

    @Column(name = "purchae_order_number", length = 50)
    private String purchaeOrderNumber;

    @Column(name = "pharmacy_supplier_invoice_number", length = 50, nullable = false)
    private String pharmacySupplierInvoiceNumber;

    @Column(name = "invoice_date", nullable = false)
    private Date invoiceDate;

    @Column(name = "pharmacy_supplier_id", nullable = false)
    private Long pharmacySupplierId;

    @Column(name = "received_date", nullable = false)
    private Date receivedDate;

    @Column(name = "received_by", length = 150)
    private String receivedBy;

    @Column(name = "warehouse_id", nullable = false)
    private Long warehouseId;

    @Column(name = "transport_mode", length = 50)
    private String transportMode;

    @Column(name = "vehicle_number", length = 50)
    private String vehicleNumber;

    @Column(name = "received_from", length = 255)
    private String receivedFrom;

    @Column(name = "overall_condition", length = 50)
    private String overallCondition;

    @Column(name = "cgst_percent", precision = 10, scale = 2)
    private BigDecimal cgstPercent;

    @Column(name = "sgst_percent", precision = 10, scale = 2)
    private BigDecimal sgstPercent;

    @Column(name = "discount_amount", precision = 12, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "total_amount", precision = 12, scale = 2, nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "payable_amount", precision = 12, scale = 2, nullable = false)
    private BigDecimal payableAmount;

    @Column(name = "paid_amount", precision = 12, scale = 2)
    private BigDecimal paidAmount;

    @Column(name = "amount_due", precision = 12, scale = 2)
    private BigDecimal amountDue;

    @Column(name = "payment_status", length = 20)
    private String paymentStatus;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "created_by", length = 150)
    private String createdBy;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "updated_by", length = 150)
    private String updatedBy;

    @OneToMany(mappedBy = "warehouseGoodsReceived", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WarehouseGoodsReceivedItem> items;
}
