package com.medical.caresync.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class CampPurchaseOrderResponseDTO {

    private Long purchaseOrderId;
    private Long campId;
    private String campName;
    private Long pharmacySupplierId;
    private String supplierName;
    private String orderStatus;
    private Timestamp requestedAt;
    private Timestamp reviewedAt;
    private String remarks;
    private List<OrderLineDTO> orderLines;

    public CampPurchaseOrderResponseDTO() {
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Long getCampId() {
        return campId;
    }

    public void setCampId(Long campId) {
        this.campId = campId;
    }

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public Long getPharmacySupplierId() {
        return pharmacySupplierId;
    }

    public void setPharmacySupplierId(Long pharmacySupplierId) {
        this.pharmacySupplierId = pharmacySupplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Timestamp getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(Timestamp requestedAt) {
        this.requestedAt = requestedAt;
    }

    public Timestamp getReviewedAt() {
        return reviewedAt;
    }

    public void setReviewedAt(Timestamp reviewedAt) {
        this.reviewedAt = reviewedAt;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<OrderLineDTO> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineDTO> orderLines) {
        this.orderLines = orderLines;
    }

    public static class OrderLineDTO {
        private Long orderLineId;
        private Long medicationId;
        private String medicationName;
        private Integer requestedQuantity;
        private Integer approvedQuantity;
        private BigDecimal approvedUnitPrice;
        private String lineStatus;
        private String supplierComment;

        public OrderLineDTO() {
        }

        public Long getOrderLineId() {
            return orderLineId;
        }

        public void setOrderLineId(Long orderLineId) {
            this.orderLineId = orderLineId;
        }

        public Long getMedicationId() {
            return medicationId;
        }

        public void setMedicationId(Long medicationId) {
            this.medicationId = medicationId;
        }

        public String getMedicationName() {
            return medicationName;
        }

        public void setMedicationName(String medicationName) {
            this.medicationName = medicationName;
        }

        public Integer getRequestedQuantity() {
            return requestedQuantity;
        }

        public void setRequestedQuantity(Integer requestedQuantity) {
            this.requestedQuantity = requestedQuantity;
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
