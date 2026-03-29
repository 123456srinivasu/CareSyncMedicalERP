package com.medical.caresync.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseOrderDTO implements Serializable {
    private Long purchaseOrderId;
    private Long supplierId;
    private Long warehouseId;

    @JsonProperty("purchaseOrderDate")
    private String purchaseOrderDateStr;
    
    private String expectedDeliveryDate;
    private String priority;
    private String orderStatus;
    private String remarks;
    private String paymentTerms;
    private String purchaseOrderNumber;
    
    private PurchaseOrderDeliveryAddressDTO deliveryAddress;
    private List<PurchaseOrderItemDTO> items;
    private PharmacySupplierDTO supplier;
    private WarehouseMasterDTO warehouse;

    // Metadata
    private String createdBy;
    @JsonProperty("createdAt")
    private String createdAtStr;
    private String updatedBy;
    @JsonProperty("updatedAt")
    private String updatedAtStr;

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getPurchaseOrderDate() {
        return purchaseOrderDateStr;
    }

    public void setPurchaseOrderDate(String purchaseOrderDateStr) {
        this.purchaseOrderDateStr = purchaseOrderDateStr;
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

    public PurchaseOrderDeliveryAddressDTO getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(PurchaseOrderDeliveryAddressDTO deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<PurchaseOrderItemDTO> getItems() {
        return items != null ? items : Collections.emptyList();
    }

    public void setItems(List<PurchaseOrderItemDTO> items) {
        this.items = items;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAtStr;
    }

    public void setCreatedAt(String createdAtStr) {
        this.createdAtStr = createdAtStr;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedAt() {
        return updatedAtStr;
    }

    public void setUpdatedAt(String updatedAtStr) {
        this.updatedAtStr = updatedAtStr;
    }

    public PharmacySupplierDTO getSupplier() {
        return supplier;
    }

    public void setSupplier(PharmacySupplierDTO supplier) {
        this.supplier = supplier;
    }

    public WarehouseMasterDTO getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseMasterDTO warehouse) {
        this.warehouse = warehouse;
    }
}
