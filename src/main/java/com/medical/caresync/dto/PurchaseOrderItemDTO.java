package com.medical.caresync.dto;

import java.io.Serializable;

public class PurchaseOrderItemDTO implements Serializable {
    private Long purchaseOrderItemId;
    private Long medicineId;
    private Integer requestedQuantity;
    private MedicinesDTO medicine;

    public Long getPurchaseOrderItemId() {
        return purchaseOrderItemId;
    }

    public void setPurchaseOrderItemId(Long purchaseOrderItemId) {
        this.purchaseOrderItemId = purchaseOrderItemId;
    }

    public Long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Long medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(Integer requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public MedicinesDTO getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicinesDTO medicine) {
        this.medicine = medicine;
    }
}
