package com.medical.caresync.dto;

import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseCampMedicineOrderDTO {
    private Long warehouseCampMedicineOrderId;
    private String warehouseCampOrderNumber;
    private Long warehouseId;
    private String warehouseName;
    private Long campId;
    private String campName;
    private LocalDate orderDate;
    private LocalDate expectedDeliveryDate;
    private String priority;
    private String orderStatus;
    private String paymentTerms;
    private String remarks;
    
    // Audit Fields
    private java.time.LocalDateTime createdAt;
    private String createdBy;
    private java.time.LocalDateTime updatedAt;
    private String updatedBy;

    private List<WarehouseCampMedicineOrderItemDTO> items;
}
