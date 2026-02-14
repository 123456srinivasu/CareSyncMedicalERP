package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "camp_patient_assessment_notes")
public class CampPatientAssessmentNotes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_id")
    private Long assessmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id", nullable = false)
    private Camps camp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_consultation_id")
    private PatientConsultation patientConsultation;

    @Column(name = "assessment_notes_type", columnDefinition = "TEXT", nullable = false)
    private String assessmentNotesType;

    @Column(name = "notes", columnDefinition = "TEXT", nullable = false)
    private String notes;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    private Users createdBy;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "user_id")
    private Users updatedBy;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
        if (isActive == null) {
            isActive = true;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public CampPatientAssessmentNotes() {
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Camps getCamp() {
        return camp;
    }

    public void setCamp(Camps camp) {
        this.camp = camp;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientConsultation getPatientConsultation() {
        return patientConsultation;
    }

    public void setPatientConsultation(PatientConsultation patientConsultation) {
        this.patientConsultation = patientConsultation;
    }

    public String getAssessmentNotesType() {
        return assessmentNotesType;
    }

    public void setAssessmentNotesType(String assessmentNotesType) {
        this.assessmentNotesType = assessmentNotesType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Users getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Users updatedBy) {
        this.updatedBy = updatedBy;
    }
}
