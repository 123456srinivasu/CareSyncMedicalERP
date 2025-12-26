package com.medical.caresync.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tbl_patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBL_PATIENT_ID")
    private Long tblPatientId;

    @Column(name = "FIRST_NM")
    private String firstNm;

    @Column(name = "LAST_NM")
    private String lastNm;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    public Patient() {
    }

    public Patient(Long tblPatientId, String firstNm, String lastNm, Integer age, String mobileNumber) {
        this.tblPatientId = tblPatientId;
        this.firstNm = firstNm;
        this.lastNm = lastNm;
        this.age = age;
        this.mobileNumber = mobileNumber;
    }

    public Long getTblPatientId() {
        return tblPatientId;
    }

    public void setTblPatientId(Long tblPatientId) {
        this.tblPatientId = tblPatientId;
    }

    public String getFirstNm() {
        return firstNm;
    }

    public void setFirstNm(String firstNm) {
        this.firstNm = firstNm;
    }

    public String getLastNm() {
        return lastNm;
    }

    public void setLastNm(String lastNm) {
        this.lastNm = lastNm;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
