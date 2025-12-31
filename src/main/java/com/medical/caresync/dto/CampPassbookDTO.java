package com.medical.caresync.dto;

import java.io.Serializable;
import java.util.Date;

public class CampPassbookDTO {

    private Long id;
    private Integer campId;
    private Date date;
    private String personNm;
    private String reason;
    private Double creditAmt;
    private Double debitAmt;
    private String statusCd;
    private Double amount;
    private String creationUserId;
    private String lastUpdateUserId;
    public CampPassbookDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getCampId() {
        return campId;
    }
    public void setCampId(Integer campId) {
        this.campId = campId;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getPersonNm() {
        return personNm;
    }
    public void setPersonNm(String personNm) {
        this.personNm = personNm;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public Double getCreditAmt() {
        return creditAmt;
    }
    public void setCreditAmt(Double creditAmt) {
        this.creditAmt = creditAmt;
    }
    public Double getDebitAmt() {
        return debitAmt;
    }
    public void setDebitAmt(Double debitAmt) {
        this.debitAmt = debitAmt;
    }
    public String getStatusCd() {
        return statusCd;
    }
    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getCreationUserId() {
        return creationUserId;
    }
    public void setCreationUserId(String creationUserId) {
        this.creationUserId = creationUserId;
    }
    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }
    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }
}
