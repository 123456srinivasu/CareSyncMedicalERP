package com.medical.caresync.dto;

public class CampQuestionOptionDTO {

    private Long optionId;
    private String optionText;
    private Long nextQuestionId;

    public CampQuestionOptionDTO() {
    }

    public CampQuestionOptionDTO(Long optionId, String optionText, Long nextQuestionId) {
        this.optionId = optionId;
        this.optionText = optionText;
        this.nextQuestionId = nextQuestionId;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Long getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(Long nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }
}
