package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "tbl_camp_passbook")
public class CampPassbook implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBL_CAMP_PASSBOOK_ID")
    private Long id;
    @Column(name = "TBL_CAMP_ID")
    private Integer campId;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;
    @Column(name = "PERSON_NM")
    private String personNm;
    @Column(name = "reason")
    private String reason;
    @Column(name = "CREDIT_AMT")
    private Double creditAmt;
    @Column(name = "DEBIT_AMT")
    private Double debitAmt;
    @Column(name = "STATUS_CD")
    private String statusCd;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "CREATION_USER_ID")
    private String creationUserId;
    @Column(name = "CREATION_TS")
    private Timestamp creationTs;
    @Column(name = "LAST_UPDATE_USER_ID")
    private String lastUpdateUserId;
    @Column(name = "LAST_UPDATE_TS")
    private Timestamp lastUpdateTs;
    public CampPassbook() {
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
    public Timestamp getCreationTs() {
        return creationTs;
    }
    public void setCreationTs(Timestamp creationTs) {
        this.creationTs = creationTs;
    }
    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }
    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }
    public Timestamp getLastUpdateTs() {
        return lastUpdateTs;
    }
    public void setLastUpdateTs(Timestamp lastUpdateTs) {
        this.lastUpdateTs = lastUpdateTs;
    }
}
