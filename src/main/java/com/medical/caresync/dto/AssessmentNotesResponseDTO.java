package com.medical.caresync.dto;

public class AssessmentNotesResponseDTO {

    private String message;
    private Long assessmentId;
    private Long campId;
    private Long patientId;

    public AssessmentNotesResponseDTO() {
    }

    public AssessmentNotesResponseDTO(String message, Long assessmentId, Long campId, Long patientId) {
        this.message = message;
        this.assessmentId = assessmentId;
        this.campId = campId;
        this.patientId = patientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
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
}
