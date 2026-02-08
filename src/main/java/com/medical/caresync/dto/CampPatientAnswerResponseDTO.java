package com.medical.caresync.dto;

public class CampPatientAnswerResponseDTO {

    private String message;
    private Integer savedCount;
    private Long campId;
    private Long patientId;

    public CampPatientAnswerResponseDTO() {
    }

    public CampPatientAnswerResponseDTO(String message, Integer savedCount, Long campId, Long patientId) {
        this.message = message;
        this.savedCount = savedCount;
        this.campId = campId;
        this.patientId = patientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getSavedCount() {
        return savedCount;
    }

    public void setSavedCount(Integer savedCount) {
        this.savedCount = savedCount;
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
