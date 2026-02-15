package com.medical.caresync.dto;

import java.sql.Timestamp;

public class CampPatientMedicinePrescriptionResponseDTO {

    private Long prescriptionId;
    private Long campId;
    private Long patientId;
    private Long medicineId;
    private String medicationName;
    private String medicationCode;
    private String medicineType;
    private Integer quantity;
    private String schedule;
    private String dosage;
    private Integer durationDays;
    private String instructions;
    private Long patientConsultationId;
    private Long prescribedBy;
    private Boolean isActive;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp updatedAt;
    private String updatedBy;

    public CampPatientMedicinePrescriptionResponseDTO() {
    }

    public CampPatientMedicinePrescriptionResponseDTO(Long prescriptionId, Long campId, Long patientId, 
                                                       Long medicineId, String medicationName, String medicationCode,
                                                       String medicineType, Integer quantity, String schedule, 
                                                       String dosage, Integer durationDays, String instructions,
                                                       Long patientConsultationId, Long prescribedBy, Boolean isActive,
                                                       Timestamp createdAt, String createdBy, Timestamp updatedAt, 
                                                       String updatedBy) {
        this.prescriptionId = prescriptionId;
        this.campId = campId;
        this.patientId = patientId;
        this.medicineId = medicineId;
        this.medicationName = medicationName;
        this.medicationCode = medicationCode;
        this.medicineType = medicineType;
        this.quantity = quantity;
        this.schedule = schedule;
        this.dosage = dosage;
        this.durationDays = durationDays;
        this.instructions = instructions;
        this.patientConsultationId = patientConsultationId;
        this.prescribedBy = prescribedBy;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    // Getters and Setters
    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Long getCampId() {
        return campId;
    }

    public void setCampId(Long campId) {
        this.campId = campId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Long medicineId) {
        this.medicineId = medicineId;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Long getPatientConsultationId() {
        return patientConsultationId;
    }

    public void setPatientConsultationId(Long patientConsultationId) {
        this.patientConsultationId = patientConsultationId;
    }

    public Long getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(Long prescribedBy) {
        this.prescribedBy = prescribedBy;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
