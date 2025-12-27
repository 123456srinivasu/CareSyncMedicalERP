package com.medical.caresync.dto;

import java.io.Serializable;

public class CampDiagnosisReportDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstNm;
    private String lastNm;
    private String enrollmentId;
    private String reportData;
    public CampDiagnosisReportDTO() {}
    public CampDiagnosisReportDTO(String firstNm, String lastNm, String enrollmentId, String reportData) {
        this.firstNm = firstNm;
        this.lastNm = lastNm;
        this.enrollmentId = enrollmentId;
        this.reportData = reportData;
    }
    public String getFirstNm() { return firstNm; }
    public void setFirstNm(String firstNm) { this.firstNm = firstNm; }
    public String getLastNm() { return lastNm; }
    public void setLastNm(String lastNm) { this.lastNm = lastNm; }
    public String getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(String enrollmentId) { this.enrollmentId = enrollmentId; }
    public String getReportData() { return reportData; }
    public void setReportData(String reportData) { this.reportData = reportData; }
}
