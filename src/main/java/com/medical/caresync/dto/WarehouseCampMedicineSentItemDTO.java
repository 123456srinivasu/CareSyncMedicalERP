package com.medical.caresync.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseCampMedicineSentItemDTO {
    private Long warehouseCampMedicineSentItemId;
    private Long medicationId;
    private String medicationName;
    private String batchNumber;
    private LocalDate expiryDate;
    private Integer requestedQuantity;
    private Integer sentQuantity;
    private BigDecimal unitPrice;
    private BigDecimal mrp;
    private String remarks;
}
