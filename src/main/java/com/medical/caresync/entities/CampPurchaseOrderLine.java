package com.medical.caresync.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "camp_purchase_order_line", uniqueConstraints = @UniqueConstraint(name = "uq_order_medication", columnNames = {
        "purchase_order_id", "medication_id" }))
public class CampPurchaseOrderLine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_id")
    private Long orderLineId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cpol_order"))
    @JsonBackReference("purchase-order-lines")
    private CampPurchaseOrder purchaseOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cpol_medication"))
    @JsonBackReference
    private MedicineLookupNew medication;

    @Column(name = "requested_quantity", nullable = false)
    private Integer requestedQuantity;

    @Column(name = "approved_quantity", columnDefinition = "INT DEFAULT 0")
    private Integer approvedQuantity;

    @Column(name = "approved_unit_price", precision = 10, scale = 2)
    private BigDecimal approvedUnitPrice;

    @Column(name = "line_status", length = 30, nullable = false)
    private String lineStatus;
    // REQUESTED | APPROVED | REJECTED | PARTIAL

    @Column(name = "supplier_comment", length = 255)
    private String supplierComment;

    public CampPurchaseOrderLine() {
    }

    @PrePersist
    protected void onCreate() {
        if (approvedQuantity == null) {
            approvedQuantity = 0;
        }
    }

    public Long getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(Long orderLineId) {
        this.orderLineId = orderLineId;
    }

    public CampPurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(CampPurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public MedicineLookupNew getMedication() {
        return medication;
    }

    public void setMedication(MedicineLookupNew medication) {
        this.medication = medication;
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
