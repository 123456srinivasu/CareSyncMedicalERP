package com.medical.caresync.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CampPatientMedicinePrescriptionRequestDTO {

    @NotNull(message = "Camp ID is required")
    private Long campId;

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Medicine ID is required")
    private Long medicineId;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantity;

    private String schedule;
    private String dosage;
    private Integer durationDays;
    private String instructions;
    private Long patientConsultationId;
    private Long prescribedBy;
    private String createdBy;
    private String updatedBy;

    public CampPatientMedicinePrescriptionRequestDTO() {
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
