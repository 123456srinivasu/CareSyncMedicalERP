package com.medical.caresync.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "camp_patient_medicine_prescription")
public class CampPatientMedicinePrescription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id")
    private Long prescriptionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id", referencedColumnName = "camp_id", nullable = false)
    @JsonBackReference("camp-prescriptions")
    private Camps camps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "tbl_patient_id", nullable = false)
    @JsonBackReference("patient-prescriptions")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id", referencedColumnName = "medication_id", nullable = false)
    private MedicineLookupNew medicineLookupNew;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "schedule", length = 255)
    private String schedule;

    @Column(name = "dosage", length = 100)
    private String dosage;

    @Column(name = "duration_days")
    private Integer durationDays;

    @Column(name = "instructions", columnDefinition = "TEXT")
    private String instructions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_consultation_id", referencedColumnName = "PATIENT_CONSULTATION_ID")
    private PatientConsultation patientConsultation;

    @Column(name = "prescribed_by")
    private Long prescribedBy;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "created_by", length = 150)
    private String createdBy;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "updated_by", length = 150)
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    // Constructors
    public CampPatientMedicinePrescription() {
    }

    // Getters and Setters
    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Camps getCamps() {
        return camps;
    }

    public void setCamps(Camps camps) {
        this.camps = camps;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MedicineLookupNew getMedicineLookupNew() {
        return medicineLookupNew;
    }

    public void setMedicineLookupNew(MedicineLookupNew medicineLookupNew) {
        this.medicineLookupNew = medicineLookupNew;
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

    public PatientConsultation getPatientConsultation() {
        return patientConsultation;
    }

    public void setPatientConsultation(PatientConsultation patientConsultation) {
        this.patientConsultation = patientConsultation;
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
