package com.medical.caresync.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseCampMedicineOrderItemDTO {
    private Long warehouseCampMedicineOrderItemId;
    private Long medicationId;
    private String medicationCode;
    private String medicationName;
    private String batchNumber;
    private Integer requestedQuantity;
    private Integer suppliedQuantity;
    private Integer availableAtRequest;
    private LocalDate expiryDate;
}
