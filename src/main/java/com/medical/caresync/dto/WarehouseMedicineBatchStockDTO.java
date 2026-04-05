package com.medical.caresync.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseMedicineBatchStockDTO {
    private Long medicationId;
    private String medicationName;
    private String batchNumber;
    private Date mfgDate;
    private Date expiryDate;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal mrp;
    private String supplierName;
}
