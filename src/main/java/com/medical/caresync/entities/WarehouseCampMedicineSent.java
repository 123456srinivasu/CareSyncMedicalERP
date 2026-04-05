package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "warehouse_camp_medicine_sent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseCampMedicineSent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_camp_medicine_sent_id")
    private Long warehouseCampMedicineSentId;

    @Column(name = "warehouse_camp_invoice_number", length = 50, nullable = false, unique = true)
    private String warehouseCampInvoiceNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_camp_medicine_order_id", nullable = false)
    private WarehouseCampMedicineOrder warehouseCampMedicineOrder;

    @Column(name = "warehouse_camp_order_number", length = 50)
    private String warehouseCampOrderNumber;

    @Column(name = "warehouse_id", nullable = false)
    private Long warehouseId;

    @Column(name = "camp_id", nullable = false)
    private Long campId;

    @Column(name = "sent_date", nullable = false)
    private LocalDateTime sentDate;

    @Column(name = "issued_by", length = 150)
    private String issuedBy;

    @Column(name = "transport_mode", length = 50)
    private String transportMode;

    @Column(name = "vehicle_number", length = 50)
    private String vehicleNumber;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "cgst_percent")
    private BigDecimal cgstPercent;

    @Column(name = "sgst_percent")
    private BigDecimal sgstPercent;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "payable_amount")
    private BigDecimal payableAmount;

    @Column(name = "paid_amount")
    private BigDecimal paidAmount;

    @Column(name = "amount_due")
    private BigDecimal amountDue;

    @Column(name = "payment_status", length = 20)
    private String paymentStatus;

    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "created_by", length = 150)
    private String createdBy;

    @OneToMany(mappedBy = "warehouseCampMedicineSent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WarehouseCampMedicineSentItem> items;
}
