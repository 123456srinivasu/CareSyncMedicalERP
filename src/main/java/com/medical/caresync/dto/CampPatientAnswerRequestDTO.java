package com.medical.caresync.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CampPatientAnswerRequestDTO {

    @NotNull(message = "Camp ID is required")
    private Long campId;

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotEmpty(message = "Answers list cannot be empty")
    @Valid
    private List<AnswerDTO> answers;

    public CampPatientAnswerRequestDTO() {
    }

    public CampPatientAnswerRequestDTO(Long campId, Long patientId, List<AnswerDTO> answers) {
        this.campId = campId;
        this.patientId = patientId;
        this.answers = answers;
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

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    public static class AnswerDTO {

        @NotNull(message = "Question ID is required")
        private Long questionId;

        private Long optionId;

        private String answerText;

        public AnswerDTO() {
        }

        public AnswerDTO(Long questionId, Long optionId, String answerText) {
            this.questionId = questionId;
            this.optionId = optionId;
            this.answerText = answerText;
        }

        public Long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }

        public Long getOptionId() {
            return optionId;
        }

        public void setOptionId(Long optionId) {
            this.optionId = optionId;
        }

        public String getAnswerText() {
            return answerText;
        }

        public void setAnswerText(String answerText) {
            this.answerText = answerText;
        }
    }
}
