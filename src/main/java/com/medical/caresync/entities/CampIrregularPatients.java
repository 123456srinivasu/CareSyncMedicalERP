package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tbl_patient")
public class CampIrregularPatients implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TBL_PATIENT_ID")
	private Long id;
	@Column(name = "FIRST_NM")
	private String firstNm;
	
	@Column(name = "LAST_NM")
	private String lastNm;
	
	@Column(name = "ENROLLMENT_DT")
	private Date enrollmentDt;
	@Transient
	private Long patientsCamps;
	@Transient
	private Long totalCamps;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getEnrollmentDt() {
		return enrollmentDt;
	}
	public void setEnrollmentDt(Date enrollmentDt) {
		this.enrollmentDt = enrollmentDt;
	}
	public Long getPatientsCamps() {
		return patientsCamps;
	}
	public void setPatientsCamps(Long patientsCamps) {
		this.patientsCamps = patientsCamps;
	}
	public Long getTotalCamps() {
		return totalCamps;
	}
	public void setTotalCamps(Long totalCamps) {
		this.totalCamps = totalCamps;
	}
}
