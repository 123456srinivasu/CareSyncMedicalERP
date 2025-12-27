package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_patient")
public class TblPatient implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_patient_id")
    private Long tblPatientId;

    @Column(name = "first_nm")
    private String firstNm;

    @Column(name = "last_nm")
    private String lastNm;

    @Column(name = "enrollment_id")
    private String enrollmentId;

    public TblPatient() {}

    public Long getTblPatientId() { return tblPatientId; }
    public void setTblPatientId(Long tblPatientId) { this.tblPatientId = tblPatientId; }
    public String getFirstNm() { return firstNm; }
    public void setFirstNm(String firstNm) { this.firstNm = firstNm; }
    public String getLastNm() { return lastNm; }
    public void setLastNm(String lastNm) { this.lastNm = lastNm; }
    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }
}
