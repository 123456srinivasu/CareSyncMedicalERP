package com.medical.caresync.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseOrderInvoicesGroupedDTO {
    private Long purchaseOrderId;
    private String purchaseOrderNumber;
    private Long pharmacySupplierId;
    private String supplierName;
    private Long warehouseId;
    private String warehouseName;
    private String priority;
    private String orderStatus;
    private java.time.LocalDateTime purchaseOrderDate;
    private String expectedDeliveryDate;
    private List<WarehouseGoodsReceivedDTO> invoices;
}
