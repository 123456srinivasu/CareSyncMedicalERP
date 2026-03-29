package com.medical.caresync.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_id")
    private Long purchaseOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private PharmacySupplier supplier;

    @Column(name = "supplier_id", nullable = false)
    private Long rawSupplierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private WarehouseMaster warehouse;

    @Column(name = "warehouse_id")
    private Long rawWarehouseId;

    @Column(name = "purchase_order_date")
    private LocalDateTime purchaseOrderDate;

    @Column(name = "expected_delivery_date")
    private String expectedDeliveryDate;

    @Column(name = "priority", length = 20)
    private String priority;

    @Column(name = "order_status", length = 20)
    private String orderStatus;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "payment_terms", length = 100)
    private String paymentTerms;

    @Column(name = "purchase_order_number", length = 50)
    private String purchaseOrderNumber;

    @OneToOne(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private PurchaseOrderDeliveryAddress deliveryAddress;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseOrderItem> items = new ArrayList<>();

    @Column(name = "created_by", length = 150)
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 150)
    private String updatedBy;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    public PurchaseOrder() {
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public PharmacySupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(PharmacySupplier supplier) {
        this.supplier = supplier;
    }

    public Long getRawSupplierId() {
        return rawSupplierId;
    }

    public void setRawSupplierId(Long rawSupplierId) {
        this.rawSupplierId = rawSupplierId;
    }

    public WarehouseMaster getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseMaster warehouse) {
        this.warehouse = warehouse;
    }

    public Long getRawWarehouseId() {
        return rawWarehouseId;
    }

    public void setRawWarehouseId(Long rawWarehouseId) {
        this.rawWarehouseId = rawWarehouseId;
    }

    public LocalDateTime getPurchaseOrderDate() {
        return purchaseOrderDate;
    }

    public void setPurchaseOrderDate(LocalDateTime purchaseOrderDate) {
        this.purchaseOrderDate = purchaseOrderDate;
    }

    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public PurchaseOrderDeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(PurchaseOrderDeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        if (deliveryAddress != null) {
            deliveryAddress.setPurchaseOrder(this);
        }
    }

    public List<PurchaseOrderItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseOrderItem> items) {
        this.items = items;
    }

    public void addItem(PurchaseOrderItem item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        item.setPurchaseOrder(this);
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
