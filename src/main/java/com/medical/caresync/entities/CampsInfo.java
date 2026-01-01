package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "camps_info")
public class CampsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_camp_id")
    private Long tblCampId;

    @Column(name = "camp_nm")
    private String campNm;

    @Column(name = "camp_establishment_dt")
    @Temporal(TemporalType.DATE)
    private Date campEstablishmentDt;

    @Column(name = "organizer_nm")
    private String organizerNm;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "location")
    private String location;

    @Column(name = "january")
    private String january;

    @Column(name = "february")
    private String february;

    @Column(name = "march")
    private String march;

    @Column(name = "april")
    private String april;

    @Column(name = "may")
    private String may;

    @Column(name = "june")
    private String june;

    @Column(name = "july")
    private String july;

    @Column(name = "august")
    private String august;

    @Column(name = "september")
    private String september;

    @Column(name = "october")
    private String october;

    @Column(name = "november")
    private String november;

    @Column(name = "december")
    private String december;

    @Column(name = "conducted_week")
    private String conductedWeek;

    @Column(name = "conducted_day")
    private String conductedDay;

    public Long getTblCampId() {
        return tblCampId;
    }

    public void setTblCampId(Long tblCampId) {
        this.tblCampId = tblCampId;
    }

    public String getCampNm() {
        return campNm;
    }

    public void setCampNm(String campNm) {
        this.campNm = campNm;
    }

    public Date getCampEstablishmentDt() {
        return campEstablishmentDt;
    }

    public void setCampEstablishmentDt(Date campEstablishmentDt) {
        this.campEstablishmentDt = campEstablishmentDt;
    }

    public String getOrganizerNm() {
        return organizerNm;
    }

    public void setOrganizerNm(String organizerNm) {
        this.organizerNm = organizerNm;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJanuary() {
        return january;
    }

    public void setJanuary(String january) {
        this.january = january;
    }

    public String getFebruary() {
        return february;
    }

    public void setFebruary(String february) {
        this.february = february;
    }

    public String getMarch() {
        return march;
    }

    public void setMarch(String march) {
        this.march = march;
    }

    public String getApril() {
        return april;
    }

    public void setApril(String april) {
        this.april = april;
    }

    public String getMay() {
        return may;
    }

    public void setMay(String may) {
        this.may = may;
    }

    public String getJune() {
        return june;
    }

    public void setJune(String june) {
        this.june = june;
    }

    public String getJuly() {
        return july;
    }

    public void setJuly(String july) {
        this.july = july;
    }

    public String getAugust() {
        return august;
    }

    public void setAugust(String august) {
        this.august = august;
    }

    public String getSeptember() {
        return september;
    }

    public void setSeptember(String september) {
        this.september = september;
    }

    public String getOctober() {
        return october;
    }

    public void setOctober(String october) {
        this.october = october;
    }

    public String getNovember() {
        return november;
    }

    public void setNovember(String november) {
        this.november = november;
    }

    public String getDecember() {
        return december;
    }

    public void setDecember(String december) {
        this.december = december;
    }

    public String getConductedWeek() {
        return conductedWeek;
    }

    public void setConductedWeek(String conductedWeek) {
        this.conductedWeek = conductedWeek;
    }

    public String getConductedDay() {
        return conductedDay;
    }

    public void setConductedDay(String conductedDay) {
        this.conductedDay = conductedDay;
    }
}
