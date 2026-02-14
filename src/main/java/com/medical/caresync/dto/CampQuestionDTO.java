package com.medical.caresync.dto;

import java.util.List;

public class CampQuestionDTO {

    private Long questionId;
    private String questionText;
    private String questionType;
    private String questionsCategory;
    private String defaultDisplay;
    private List<CampQuestionOptionDTO> options;

    public CampQuestionDTO() {
    }

    public CampQuestionDTO(Long questionId, String questionText, String questionType, String questionsCategory, String defaultDisplay, List<CampQuestionOptionDTO> options) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.questionType = questionType;
        this.questionsCategory = questionsCategory;
        this.defaultDisplay = defaultDisplay;
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

    public String getQuestionsCategory() {
        return questionsCategory;
    }

    public void setQuestionsCategory(String questionsCategory) {
        this.questionsCategory = questionsCategory;
    }

    public String getDefaultDisplay() {
        return defaultDisplay;
    }

    public void setDefaultDisplay(String defaultDisplay) {
        this.defaultDisplay = defaultDisplay;
    }
}
