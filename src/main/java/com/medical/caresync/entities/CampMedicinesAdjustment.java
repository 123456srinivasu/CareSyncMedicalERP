package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "camp_medicines_adjustment")
public class CampMedicinesAdjustment implements Serializable {

    private static final long serialVersionUID = 1L;

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adjustment_id")
    private Long adjustmentId;
    @Column(name = "camp_details_id")
    private Long campDetailsId;
    @Column(name = "medicine_nm")
    private String medicineNm;
    @Column(name = "manufacturing_company")
    private String manufacturingCompany;
    @Column(name = "camp_ending_quantity")
    private Integer campEndingQuantity;
    @Column(name = "adjusted_quantity")
    private Integer adjustedQuantity;
    @Column(name = "difference")
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
    

