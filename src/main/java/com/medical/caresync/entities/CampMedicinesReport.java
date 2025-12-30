package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_patient_medication")
public class CampMedicinesReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "tbl_patient_medication_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbl_medicines_id", referencedColumnName = "tbl_medicines_id")
    private Medicine medicine;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbl_patient_id", referencedColumnName = "tbl_patient_id")
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbl_camp_detail_id", referencedColumnName = "tbl_camp_detail_id")
    private CampDetail campDetail;
    @Column(name = "morning")
    private Integer morning;
    @Column(name = "afternoon")
    private Integer afternoon;
    @Column(name = "night")
    private Integer night;
    @Column(name = "quantity_issued")
    private Integer quantityIssued;
    @Column(name = "created_dt")
    private LocalDate createdDt;
    @Column(name = "updated_dt")
    private LocalDate updatedDt;
    public CampMedicinesReport() {
    }
    public CampMedicinesReport(Long id, Medicine medicine, Patient patient, CampDetail campDetail, 
                               Integer morning, Integer afternoon, Integer night, Integer quantityIssued, 
                               LocalDate createdDt, LocalDate updatedDt) {
        this.id = id;
        this.medicine = medicine;
        this.patient = patient;
        this.campDetail = campDetail;
        this.morning = morning;
        this.afternoon = afternoon;
        this.night = night;
        this.quantityIssued = quantityIssued;
        this.createdDt = createdDt;
        this.updatedDt = updatedDt;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Medicine getMedicine() {
        return medicine;
    }
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public CampDetail getCampDetail() {
        return campDetail;
    }
    public void setCampDetail(CampDetail campDetail) {
        this.campDetail = campDetail;
    }
    public Integer getMorning() {
        return morning;
    }
    public void setMorning(Integer morning) {
        this.morning = morning;
    }
    public Integer getAfternoon() {
        return afternoon;
    }
    public void setAfternoon(Integer afternoon) {
        this.afternoon = afternoon;
    }
    public Integer getNight() {
        return night;
    }
    public void setNight(Integer night) {
        this.night = night;
    }
    public Integer getQuantityIssued() {
        return quantityIssued;
    }
    public void setQuantityIssued(Integer quantityIssued) {
        this.quantityIssued = quantityIssued;
    }
    public LocalDate getCreatedDt() {
        return createdDt;
    }
    public void setCreatedDt(LocalDate createdDt) {
        this.createdDt = createdDt;
    }
    public LocalDate getUpdatedDt() {
        return updatedDt;
    }
    public void setUpdatedDt(LocalDate updatedDt) {
        this.updatedDt = updatedDt;
    }
}
