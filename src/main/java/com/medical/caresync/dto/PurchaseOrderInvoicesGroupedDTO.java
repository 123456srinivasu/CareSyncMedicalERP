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
    private List<WarehouseGoodsReceivedDTO> invoices;
}
