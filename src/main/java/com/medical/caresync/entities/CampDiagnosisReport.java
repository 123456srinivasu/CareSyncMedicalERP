package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "camp_diagnosis_report")
public class CampDiagnosisReport implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_patient_consultation_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbl_patient_id")
    private TblPatient patient;
    @Column(name = "report_data")
    private String reportData;
    private String diagnosis;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbl_camp_details_id")
    private TblCampDetail campDetail;
    public CampDiagnosisReport() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TblPatient getPatient() { return patient; }
    public void setPatient(TblPatient patient) { this.patient = patient; }
    public String getReportData() { return reportData; }
    public void setReportData(String reportData) { this.reportData = reportData; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public TblCampDetail getCampDetail() { return campDetail; }
    public void setCampDetail(TblCampDetail campDetail) { this.campDetail = campDetail; }
}
