package com.medical.caresync.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseMedicineStockSummaryDTO {
    private Long medicationId;
    private String medicationName;
    private String medicationCode;
    private String medicineType;
    private Long totalQuantity;
    private Integer minStockLevel;
    private Integer maxStockLevel;
    private Long pharmacySupplierId;
    private String preferredSupplierName;
    private String warehouseName;
}
