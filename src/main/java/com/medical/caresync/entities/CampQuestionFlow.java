package com.medical.caresync.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "camp_question_flow")
public class CampQuestionFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flow_id")
    private Long flowId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    @JsonIgnore
    private CampQuestion question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id", nullable = false)
    private CampQuestionOption option;

    @Column(name = "next_question_id", nullable = false)
    private Long nextQuestionId;

    @Column(name = "is_active")
    private Boolean isActive;

    public CampQuestionFlow() {
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public CampQuestion getQuestion() {
        return question;
    }

    public void setQuestion(CampQuestion question) {
        this.question = question;
    }

    public CampQuestionOption getOption() {
        return option;
    }

    public void setOption(CampQuestionOption option) {
        this.option = option;
    }

    public Long getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(Long nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
