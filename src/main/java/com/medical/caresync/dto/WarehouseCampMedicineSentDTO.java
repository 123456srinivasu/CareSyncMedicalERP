package com.medical.caresync.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseCampMedicineSentDTO {
    private Long warehouseCampMedicineSentId;
    private String warehouseCampInvoiceNumber;
    private Long warehouseCampMedicineOrderId;
    private String warehouseCampOrderNumber;
    private Long warehouseId;
    private Long campId;
    private LocalDateTime sentDate;
    private String issuedBy;
    private String transportMode;
    private String vehicleNumber;
    private String status;
    
    // Financial Fields
    private BigDecimal cgstPercent;
    private BigDecimal sgstPercent;
    private BigDecimal discountAmount;
    private BigDecimal totalAmount;
    private BigDecimal payableAmount;
    private BigDecimal paidAmount;
    private BigDecimal amountDue;
    private String paymentStatus;

    private LocalDateTime createdAt;
    private String createdBy;
    private List<WarehouseCampMedicineSentItemDTO> items;
}
