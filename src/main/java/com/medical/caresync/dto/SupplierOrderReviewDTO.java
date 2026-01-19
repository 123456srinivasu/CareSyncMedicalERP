package com.medical.caresync.dto;

import java.math.BigDecimal;
import java.util.List;

public class SupplierOrderReviewDTO {

    private Long purchaseOrderId;
    private String orderStatus; // ACCEPTED | REJECTED | PARTIALLY_ACCEPTED
    private String remarks;
    private List<OrderLineReviewDTO> orderLines;

    public SupplierOrderReviewDTO() {
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<OrderLineReviewDTO> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineReviewDTO> orderLines) {
        this.orderLines = orderLines;
    }

    public static class OrderLineReviewDTO {
        private Long orderLineId;
        private Integer approvedQuantity;
        private BigDecimal approvedUnitPrice;
        private String lineStatus; // APPROVED | REJECTED | PARTIAL
        private String supplierComment;

        public OrderLineReviewDTO() {
        }

        public Long getOrderLineId() {
            return orderLineId;
        }

        public void setOrderLineId(Long orderLineId) {
            this.orderLineId = orderLineId;
        }

        public Integer getApprovedQuantity() {
            return approvedQuantity;
        }

        public void setApprovedQuantity(Integer approvedQuantity) {
            this.approvedQuantity = approvedQuantity;
        }

        public BigDecimal getApprovedUnitPrice() {
            return approvedUnitPrice;
        }

        public void setApprovedUnitPrice(BigDecimal approvedUnitPrice) {
            this.approvedUnitPrice = approvedUnitPrice;
        }

        public String getLineStatus() {
            return lineStatus;
        }

        public void setLineStatus(String lineStatus) {
            this.lineStatus = lineStatus;
        }

        public String getSupplierComment() {
            return supplierComment;
        }

        public void setSupplierComment(String supplierComment) {
            this.supplierComment = supplierComment;
        }
    }
}
