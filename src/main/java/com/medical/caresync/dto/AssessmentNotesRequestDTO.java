package com.medical.caresync.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AssessmentNotesRequestDTO {

    @NotNull(message = "Camp ID is required")
    private Long campId;

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    private Long patientConsultationId;

    @NotBlank(message = "Assessment notes type is required")
    private String assessmentNotesType;

    @NotBlank(message = "Assessment notes cannot be empty")
    private String notes;

    private Long createdById;

    public AssessmentNotesRequestDTO() {
    }

    public AssessmentNotesRequestDTO(Long campId, Long patientId, Long patientConsultationId, 
                                      String assessmentNotesType, String notes, Long createdById) {
        this.campId = campId;
        this.patientId = patientId;
        this.patientConsultationId = patientConsultationId;
        this.assessmentNotesType = assessmentNotesType;
        this.notes = notes;
        this.createdById = createdById;
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

    public Long getPatientConsultationId() {
        return patientConsultationId;
    }

    public void setPatientConsultationId(Long patientConsultationId) {
        this.patientConsultationId = patientConsultationId;
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

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }
}
