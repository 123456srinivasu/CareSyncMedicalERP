package com.medical.caresync.dto;

import lombok.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseGoodsReceivedItemDTO {
    private Long warehouseGoodsReceivedItemId;
    private Long medicationId;
    private String medicationName;
    private String medicationCode;
    private String medicineType;
    private String batchNumber;
    private Date mfgDate;
    private Date expiryDate;
    private String storageType; 
    private Integer orderedQty;
    private Integer receivedQty;
    private Integer damagedQty;
    private BigDecimal unitPrice;
    private BigDecimal mrp;
    private String qcStatus;
    private String remarks;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp updatedAt;
    private String updatedBy;
}
