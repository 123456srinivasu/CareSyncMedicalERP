package com.medical.caresync.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "camp_question")
public class CampQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "question_text", length = 500, nullable = false)
    private String questionText;

    @Column(name = "question_type", length = 50, nullable = false)
    private String questionType;

    @Column(name = "questions_category", length = 255)
    private String questionsCategory;

    @Column(name = "default_display", length = 255)
    private String defaultDisplay;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "camp_id")
    private Integer campId;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<CampQuestionOption> options = new HashSet<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<CampQuestionFlow> flows = new HashSet<>();

    public CampQuestion() {
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

    public Integer getCampId() {
        return campId;
    }

    public void setCampId(Integer campId) {
        this.campId = campId;
    }

    public Set<CampQuestionOption> getOptions() {
        return options;
    }

    public void setOptions(Set<CampQuestionOption> options) {
        this.options = options;
    }

    public Set<CampQuestionFlow> getFlows() {
        return flows;
    }

    public void setFlows(Set<CampQuestionFlow> flows) {
        this.flows = flows;
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
