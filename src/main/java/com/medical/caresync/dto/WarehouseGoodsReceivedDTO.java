package com.medical.caresync.dto;

import lombok.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseGoodsReceivedDTO {
    private Long warehouseGoodsReceivedId;
    private String warehouseGoodsReceivedNumber;
    private Long purchaseOrderId;
    private String purchaeOrderNumber; // Maps to purchae_order_number
    private LocalDateTime purchaseOrderDate;
    private String pharmacySupplierInvoiceNumber;
    private Date invoiceDate;
    private Long pharmacySupplierId;
    private Date receivedDate;
    private String receivedBy;
    private Long warehouseId;
    private String transportMode;
    private String vehicleNumber;
    private String receivedFrom;
    private String overallCondition;
    private BigDecimal cgstPercent;
    private BigDecimal sgstPercent;
    private BigDecimal discountAmount;
    private BigDecimal totalAmount;
    private BigDecimal payableAmount;
    private BigDecimal paidAmount;
    private BigDecimal amountDue;
    private String paymentStatus;
    private String pharmacySupplierName;
    private String warehouseName;
    private List<WarehouseGoodsReceivedItemDTO> items;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp updatedAt;
    private String updatedBy;
}
