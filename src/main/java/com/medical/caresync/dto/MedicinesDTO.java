package com.medical.caresync.dto;

public class MedicinesDTO {

    private Long id;
    private String medicationName;
    private String medicationCode;
    private String medicineType;
    private Long pharmacySupplierId;
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedicationCode() {
        return medicationCode;
    }

    public void setMedicationCode(String medicationCode) {
        this.medicationCode = medicationCode;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public Long getPharmacySupplierId() {
        return pharmacySupplierId;
    }

    public void setPharmacySupplierId(Long pharmacySupplierId) {
        this.pharmacySupplierId = pharmacySupplierId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
