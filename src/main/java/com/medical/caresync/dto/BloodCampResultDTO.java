package com.medical.caresync.dto;

import java.io.Serializable;
import java.util.Date;

public class BloodCampResultDTO implements Serializable {
    private Integer id;
    private String patientName;
    private String fatherName;
    private String village;
    private String mobileNumber;
    private Integer age;
    private String gender;
    private String bloodGroup;
    private Integer campId;
    private Date campDate;
    private String lipidResult;
    private String thyroidResult;
    private String creatinineResult;
    private String fbsResult;
    private String ppbsResult;
    private String breastScreeningResult;
    private String mammographyResult;
    private String papsmearResult;
    private String oralAndDentalResult;
    private String psaResult;
    private Double weight;
    private Double height;
    private Double bmi;
    private Double systolicBp;
    private Double diastolicBp;
    private Double pulseRate;
    private Double pulseOximeter;
    private String comments;
    private String comments1;
    private String comments2;
    private String comments3;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public String getVillage() { return village; }
    public void setVillage(String village) { this.village = village; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public Integer getCampId() { return campId; }
    public void setCampId(Integer campId) { this.campId = campId; }

    public Date getCampDate() { return campDate; }
    public void setCampDate(Date campDate) { this.campDate = campDate; }

    public String getLipidResult() { return lipidResult; }
    public void setLipidResult(String lipidResult) { this.lipidResult = lipidResult; }

    public String getThyroidResult() { return thyroidResult; }
    public void setThyroidResult(String thyroidResult) { this.thyroidResult = thyroidResult; }

    public String getCreatinineResult() { return creatinineResult; }
    public void setCreatinineResult(String creatinineResult) { this.creatinineResult = creatinineResult; }

    public String getFbsResult() { return fbsResult; }
    public void setFbsResult(String fbsResult) { this.fbsResult = fbsResult; }

    public String getPpbsResult() { return ppbsResult; }
    public void setPpbsResult(String ppbsResult) { this.ppbsResult = ppbsResult; }

    public String getBreastScreeningResult() { return breastScreeningResult; }
    public void setBreastScreeningResult(String breastScreeningResult) { this.breastScreeningResult = breastScreeningResult; }

    public String getMammographyResult() { return mammographyResult; }
    public void setMammographyResult(String mammographyResult) { this.mammographyResult = mammographyResult; }

    public String getPapsmearResult() { return papsmearResult; }
    public void setPapsmearResult(String papsmearResult) { this.papsmearResult = papsmearResult; }

    public String getOralAndDentalResult() { return oralAndDentalResult; }
    public void setOralAndDentalResult(String oralAndDentalResult) { this.oralAndDentalResult = oralAndDentalResult; }

    public String getPsaResult() { return psaResult; }
    public void setPsaResult(String psaResult) { this.psaResult = psaResult; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Double getBmi() { return bmi; }
    public void setBmi(Double bmi) { this.bmi = bmi; }

    public Double getSystolicBp() { return systolicBp; }
    public void setSystolicBp(Double systolicBp) { this.systolicBp = systolicBp; }

    public Double getDiastolicBp() { return diastolicBp; }
    public void setDiastolicBp(Double diastolicBp) { this.diastolicBp = diastolicBp; }

    public Double getPulseRate() { return pulseRate; }
    public void setPulseRate(Double pulseRate) { this.pulseRate = pulseRate; }

    public Double getPulseOximeter() { return pulseOximeter; }
    public void setPulseOximeter(Double pulseOximeter) { this.pulseOximeter = pulseOximeter; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public String getComments1() { return comments1; }
    public void setComments1(String comments1) { this.comments1 = comments1; }

    public String getComments2() { return comments2; }
    public void setComments2(String comments2) { this.comments2 = comments2; }

    public String getComments3() { return comments3; }
    public void setComments3(String comments3) { this.comments3 = comments3; }
}