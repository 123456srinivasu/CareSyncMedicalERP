package com.medical.caresync.dto;

import java.util.List;

public class CampQuestionDTO {

    private Long questionId;
    private String questionText;
    private String questionType;
    private List<CampQuestionOptionDTO> options;

    public CampQuestionDTO() {
    }

    public CampQuestionDTO(Long questionId, String questionText, String questionType, List<CampQuestionOptionDTO> options) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.questionType = questionType;
        this.options = options;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public List<CampQuestionOptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<CampQuestionOptionDTO> options) {
        this.options = options;
    }
}
