package com.medical.caresync.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "patient_consultation")
public class PatientConsultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_CONSULTATION_ID")
    private Long patientConsultationId;

    @Column(name = "HEIGHT")
    private Double height;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "SYSTOLIC_BP")
    private Integer systolicBp;

    @Column(name = "DIASTOLIC_BP")
    private Integer diastolicBp;

    @Column(name = "PULSE_RATE")
    private Integer pulseRate;

    @Column(name = "BMI")
    private Double bmi;

    @Column(name = "PULSE_OXIMETER")
    private Integer pulseOximeter;

    @Column(name = "SUGAR_VALUE")
    private Double sugarValue;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DISCOUNT_AMOUNT")
    private Double discountAmount;

    @Column(name = "DUE_AMOUNT")
    private Double dueAmount;

    @Column(name = "INSULIN_AMOUNT")
    private Double insulinAmount;

    @Column(name = "INSULIN_DISCOUNT_AMOUNT")
    private Double insulinDiscountAmount;

    @Column(name = "INSULIN_DUE_AMOUNT")
    private Double insulinDueAmount;

    @Column(name = "COMMENTS", length = 500)
    private String comments;

    @Column(name = "PURPOSE_OF_VISIT", length = 200)
    private String purposeOfVisit;

    @Column(name = "DATE_OF_VISIT")
    private LocalDate dateOfVisit;

    @Column(name = "CREATION_TS", updatable = false)
    private Timestamp creationTs;

    @Column(name = "CREATION_USER_ID")
    private String creationUserId;

    @Column(name = "LAST_UPDATE_TS")
    private Timestamp lastUpdateTs;

    @Column(name = "LAST_UPDATE_USER_ID")
    private String lastUpdateUserId;

    @Column(name = "PROVIDER_ID", nullable = false)
    private Integer providerId;

    // ---------- TINYINT(4) → Boolean ----------
    @Column(name = "BP", nullable = false)
    private Boolean bp;
    
    @Column(name = "DIABETICS", nullable = false)
    private Boolean diabetics;
    
    @Column(name = "AMOUNT_PAID", nullable = false)
    private Boolean amountPaid;
    
    @Column(name = "PRINT_STATUS")
    private Boolean printStatus;
    
    @Column(name = "INSULIN_AMOUNT_PAID")
    private Boolean insulinAmountPaid;
    
    @Column(name = "MEDICINES_TAKEN_BY", nullable = false)
    private Boolean medicinesTakenBy;

    @Column(name = "STATUS", length = 2)
    private String status;

    @Column(name = "COMMENT", length = 1000)
    private String comment;

    @Column(name = "DOCTOR_ID")
    private Long doctorId;

    @Column(name = "GREENCHANNEL_ID")
    private Integer greenChannelId;

    @Column(name = "AMOUNT_COLLECTED_BY")
    private String amountCollectedBy;

    @Column(name = "PHARMACY_BATCH", length = 20)
    private String pharmacyBatch;

    @Column(name = "REGISTRATION_EXIT_TIME")
    private LocalDateTime registrationExitTime;

    @Column(name = "DOCTOR_ENTRY_TIME")
    private LocalDateTime doctorEntryTime;

    @Column(name = "DOCTOR_EXIT_TIME")
    private LocalDateTime doctorExitTime;

    @Column(name = "PHARMACY_ENTRY_TIME")
    private LocalDateTime pharmacyEntryTime;

    @Column(name = "PHARMACY_EXIT_TIME")
    private LocalDateTime pharmacyExitTime;

    @Column(name = "INSULIN_ENTRY_TIME")
    private LocalDateTime insulinEntryTime;

    @Column(name = "INSULIN_EXIT_TIME")
    private LocalDateTime insulinExitTime;

    @Column(name = "DIETCOUNSELLING_ENTRY_TIME")
    private LocalDateTime dietCounsellingEntryTime;

    @Column(name = "DIETCOUNSELLING_EXIT_TIME")
    private LocalDateTime dietCounsellingExitTime;

    @Column(name = "PHARMACY_PRINT_TIME")
    private LocalDateTime pharmacyPrintTime;

    @Column(name = "CONSULTATION_TYPE", length = 2)
    private String consultationType;

    @Column(name = "DIAGNOSIS", length = 1000)
    private String diagnosis;

    @Column(name = "REPORTDATA", length = 100)
    private String reportData;

    @Column(name = "TOKEN_NM")
    private Double tokenNm;

    @Column(name = "PAY_AT_NEXT_CAMP")
    private Double payAtNextCamp;

    @Column(name = "TELEMEDICINE", length = 1)
    private String telemedicine;

    @Column(name = "MEDICINES_FOR_FREE", length = 1)
    private String medicinesForFree;

    @Column(name = "INSULIN_FOR_FREE", length = 1)
    private String insulinForFree;

    @Column(name = "TBL_CAMP_DETAILS_BLOCKS")
    private Integer tblCampDetailsBlocks;

    @Column(name = "SEIZURE_TEXT", length = 1000)
    private String seizureText;

    @Column(name = "CASHIER_ENTRY_TIME")
    private Timestamp cashierEntryTime;

    @Column(name = "CASHIER_EXIT_TIME")
    private Timestamp cashierExitTime;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID", nullable = false)
    private Patient patient;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_run_id", nullable = false)
    private CampRuns campRuns;

    public Long getPatientConsultationId() {
        return patientConsultationId;
    }

    public void setPatientConsultationId(Long patientConsultationId) {
        this.patientConsultationId = patientConsultationId;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getSystolicBp() {
        return systolicBp;
    }

    public void setSystolicBp(Integer systolicBp) {
        this.systolicBp = systolicBp;
    }

    public Integer getDiastolicBp() {
        return diastolicBp;
    }

    public void setDiastolicBp(Integer diastolicBp) {
        this.diastolicBp = diastolicBp;
    }

    public Integer getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(Integer pulseRate) {
        this.pulseRate = pulseRate;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Integer getPulseOximeter() {
        return pulseOximeter;
    }

    public void setPulseOximeter(Integer pulseOximeter) {
        this.pulseOximeter = pulseOximeter;
    }

    public Double getSugarValue() {
        return sugarValue;
    }

    public void setSugarValue(Double sugarValue) {
        this.sugarValue = sugarValue;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Double getInsulinAmount() {
        return insulinAmount;
    }

    public void setInsulinAmount(Double insulinAmount) {
        this.insulinAmount = insulinAmount;
    }

    public Double getInsulinDiscountAmount() {
        return insulinDiscountAmount;
    }

    public void setInsulinDiscountAmount(Double insulinDiscountAmount) {
        this.insulinDiscountAmount = insulinDiscountAmount;
    }

    public Double getInsulinDueAmount() {
        return insulinDueAmount;
    }

    public void setInsulinDueAmount(Double insulinDueAmount) {
        this.insulinDueAmount = insulinDueAmount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPurposeOfVisit() {
        return purposeOfVisit;
    }

    public void setPurposeOfVisit(String purposeOfVisit) {
        this.purposeOfVisit = purposeOfVisit;
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public Timestamp getCreationTs() {
        return creationTs;
    }

    public void setCreationTs(Timestamp creationTs) {
        this.creationTs = creationTs;
    }

    public String getCreationUserId() {
        return creationUserId;
    }

    public void setCreationUserId(String creationUserId) {
        this.creationUserId = creationUserId;
    }

    public Timestamp getLastUpdateTs() {
        return lastUpdateTs;
    }

    public void setLastUpdateTs(Timestamp lastUpdateTs) {
        this.lastUpdateTs = lastUpdateTs;
    }

    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Boolean getBp() {
        return bp;
    }

    public void setBp(Boolean bp) {
        this.bp = bp;
    }

    public Boolean getDiabetics() {
        return diabetics;
    }

    public void setDiabetics(Boolean diabetics) {
        this.diabetics = diabetics;
    }

    public Boolean getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Boolean amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Boolean getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(Boolean printStatus) {
        this.printStatus = printStatus;
    }

    public Boolean getInsulinAmountPaid() {
        return insulinAmountPaid;
    }

    public void setInsulinAmountPaid(Boolean insulinAmountPaid) {
        this.insulinAmountPaid = insulinAmountPaid;
    }

    public Boolean getMedicinesTakenBy() {
        return medicinesTakenBy;
    }

    public void setMedicinesTakenBy(Boolean medicinesTakenBy) {
        this.medicinesTakenBy = medicinesTakenBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getGreenChannelId() {
        return greenChannelId;
    }

    public void setGreenChannelId(Integer greenChannelId) {
        this.greenChannelId = greenChannelId;
    }

    public String getAmountCollectedBy() {
        return amountCollectedBy;
    }

    public void setAmountCollectedBy(String amountCollectedBy) {
        this.amountCollectedBy = amountCollectedBy;
    }

    public String getPharmacyBatch() {
        return pharmacyBatch;
    }

    public void setPharmacyBatch(String pharmacyBatch) {
        this.pharmacyBatch = pharmacyBatch;
    }

    public LocalDateTime getRegistrationExitTime() {
        return registrationExitTime;
    }

    public void setRegistrationExitTime(LocalDateTime registrationExitTime) {
        this.registrationExitTime = registrationExitTime;
    }

    public LocalDateTime getDoctorEntryTime() {
        return doctorEntryTime;
    }

    public void setDoctorEntryTime(LocalDateTime doctorEntryTime) {
        this.doctorEntryTime = doctorEntryTime;
    }

    public LocalDateTime getDoctorExitTime() {
        return doctorExitTime;
    }

    public void setDoctorExitTime(LocalDateTime doctorExitTime) {
        this.doctorExitTime = doctorExitTime;
    }

    public LocalDateTime getPharmacyEntryTime() {
        return pharmacyEntryTime;
    }

    public void setPharmacyEntryTime(LocalDateTime pharmacyEntryTime) {
        this.pharmacyEntryTime = pharmacyEntryTime;
    }

    public LocalDateTime getPharmacyExitTime() {
        return pharmacyExitTime;
    }

    public void setPharmacyExitTime(LocalDateTime pharmacyExitTime) {
        this.pharmacyExitTime = pharmacyExitTime;
    }

    public LocalDateTime getInsulinEntryTime() {
        return insulinEntryTime;
    }

    public void setInsulinEntryTime(LocalDateTime insulinEntryTime) {
        this.insulinEntryTime = insulinEntryTime;
    }

    public LocalDateTime getInsulinExitTime() {
        return insulinExitTime;
    }

    public void setInsulinExitTime(LocalDateTime insulinExitTime) {
        this.insulinExitTime = insulinExitTime;
    }

    public LocalDateTime getDietCounsellingEntryTime() {
        return dietCounsellingEntryTime;
    }

    public void setDietCounsellingEntryTime(LocalDateTime dietCounsellingEntryTime) {
        this.dietCounsellingEntryTime = dietCounsellingEntryTime;
    }

    public LocalDateTime getDietCounsellingExitTime() {
        return dietCounsellingExitTime;
    }

    public void setDietCounsellingExitTime(LocalDateTime dietCounsellingExitTime) {
        this.dietCounsellingExitTime = dietCounsellingExitTime;
    }

    public LocalDateTime getPharmacyPrintTime() {
        return pharmacyPrintTime;
    }

    public void setPharmacyPrintTime(LocalDateTime pharmacyPrintTime) {
        this.pharmacyPrintTime = pharmacyPrintTime;
    }

    public String getConsultationType() {
        return consultationType;
    }

    public void setConsultationType(String consultationType) {
        this.consultationType = consultationType;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getReportData() {
        return reportData;
    }

    public void setReportData(String reportData) {
        this.reportData = reportData;
    }

    public Double getTokenNm() {
        return tokenNm;
    }

    public void setTokenNm(Double tokenNm) {
        this.tokenNm = tokenNm;
    }

    public Double getPayAtNextCamp() {
        return payAtNextCamp;
    }

    public void setPayAtNextCamp(Double payAtNextCamp) {
        this.payAtNextCamp = payAtNextCamp;
    }

    public String getTelemedicine() {
        return telemedicine;
    }

    public void setTelemedicine(String telemedicine) {
        this.telemedicine = telemedicine;
    }

    public String getMedicinesForFree() {
        return medicinesForFree;
    }

    public void setMedicinesForFree(String medicinesForFree) {
        this.medicinesForFree = medicinesForFree;
    }

    public String getInsulinForFree() {
        return insulinForFree;
    }

    public void setInsulinForFree(String insulinForFree) {
        this.insulinForFree = insulinForFree;
    }

    public Integer getTblCampDetailsBlocks() {
        return tblCampDetailsBlocks;
    }

    public void setTblCampDetailsBlocks(Integer tblCampDetailsBlocks) {
        this.tblCampDetailsBlocks = tblCampDetailsBlocks;
    }

    public String getSeizureText() {
        return seizureText;
    }

    public void setSeizureText(String seizureText) {
        this.seizureText = seizureText;
    }

    public Timestamp getCashierEntryTime() {
        return cashierEntryTime;
    }

    public void setCashierEntryTime(Timestamp cashierEntryTime) {
        this.cashierEntryTime = cashierEntryTime;
    }

    public Timestamp getCashierExitTime() {
        return cashierExitTime;
    }

    public void setCashierExitTime(Timestamp cashierExitTime) {
        this.cashierExitTime = cashierExitTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public CampRuns getCampRuns() {
        return campRuns;
    }

    public void setCampRuns(CampRuns campRuns) {
        this.campRuns = campRuns;
    }

    @JsonManagedReference
    @OneToMany(
            mappedBy = "patientConsultation",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<PatientChiefComplaint> patientChiefComplaints;

}
