package com.medical.caresync.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "camp_purchase_order")
public class CampPurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_id")
    private Long purchaseOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cpo_camp"))
    @JsonBackReference
    private Camps camp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacy_supplier_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cpo_supplier"))
    @JsonBackReference
    private PharmacySupplier pharmacySupplier;

    @Column(name = "order_status", length = 30, nullable = false)
    private String orderStatus;
    // CREATED | SUBMITTED | ACCEPTED | REJECTED | PARTIALLY_ACCEPTED

    @Column(name = "requested_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp requestedAt;

    @Column(name = "reviewed_at")
    private Timestamp reviewedAt;

    @Column(name = "remarks", length = 500)
    private String remarks;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference("purchase-order-lines")
    private List<CampPurchaseOrderLine> orderLines;

    public CampPurchaseOrder() {
    }

    @PrePersist
    protected void onCreate() {
        if (requestedAt == null) {
            requestedAt = new Timestamp(System.currentTimeMillis());
        }
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Camps getCamp() {
        return camp;
    }

    public void setCamp(Camps camp) {
        this.camp = camp;
    }

    public PharmacySupplier getPharmacySupplier() {
        return pharmacySupplier;
    }

    public void setPharmacySupplier(PharmacySupplier pharmacySupplier) {
        this.pharmacySupplier = pharmacySupplier;
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

    public List<CampPurchaseOrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<CampPurchaseOrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
