package com.medical.caresync.dto;

public class CampMedicinesAdjustmentDTO {

   private Long adjustmentId;
    private Long campDetailsId;
    private String medicineNm;
    private String manufacturingCompany;
    private Integer campEndingQuantity;
    private Integer adjustedQuantity;
    private Integer difference;
    public Long getAdjustmentId() {
        return adjustmentId;
    }
    public void setAdjustmentId(Long adjustmentId) {
        this.adjustmentId = adjustmentId;
    }
    public Long getCampDetailsId() {
        return campDetailsId;
    }
    public void setCampDetailsId(Long campDetailsId) {
        this.campDetailsId = campDetailsId;
    }
    public String getMedicineNm() {
        return medicineNm;
    }
    public void setMedicineNm(String medicineNm) {
        this.medicineNm = medicineNm;
    }
    public String getManufacturingCompany() {
        return manufacturingCompany;
    }
    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = manufacturingCompany;
    }
    public Integer getCampEndingQuantity() {
        return campEndingQuantity;
    }
    public void setCampEndingQuantity(Integer campEndingQuantity) {
        this.campEndingQuantity = campEndingQuantity;
    }
    public Integer getAdjustedQuantity() {
        return adjustedQuantity;
    }
    public void setAdjustedQuantity(Integer adjustedQuantity) {
        this.adjustedQuantity = adjustedQuantity;
    }
    public Integer getDifference() {
        return difference;
    }
    public void setDifference(Integer difference) {
        this.difference = difference;
    }
}
