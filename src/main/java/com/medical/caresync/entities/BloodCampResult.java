package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "cancer_screening_manipal")
public class BloodCampResult {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CANCER_SCREENING_MANIPAL_ID")
    private Integer id;

    @Column(name = "PATIENT_NM")
    private String patientName;

    @Column(name = "FATHER_NM")
    private String fatherName;

    @Column(name = "CITY")
    private String village;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "GENDER_CD")
    private String gender;

    @Column(name = "BLOOD_GROUP")
    private String bloodGroup;

    @Column(name = "CAMP_ID")
    private Integer campId;

    @Temporal(TemporalType.DATE)
    @Column(name = "CAMP_DATE")
    private Date campDate;

    @Lob
    @Column(name = "LIPID_RESULT")
    private String lipidResult;

    @Lob
    @Column(name = "THYROID_RESULT")
    private String thyroidResult;

    @Lob
    @Column(name = "CREATININE_RESULT")
    private String creatinineResult;

    @Lob
    @Column(name = "FBS_RESULT")
    private String fbsResult;

    @Lob
    @Column(name = "PPBS_RESULT")
    private String ppbsResult;

    @Lob
    @Column(name = "B_SCREENING_RESULT")
    private String breastScreeningResult;

    @Lob
    @Column(name = "MAMMO_RESULT")
    private String mammographyResult;

    @Lob
    @Column(name = "PAPS_RESULT")
    private String papsmearResult;

    @Lob
    @Column(name = "ORALANDDENTAL_RESULT")
    private String oralAndDentalResult;

    @Lob
    @Column(name = "PS_RESULT")
    private String psaResult;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "HEIGHT")
    private Double height;

    @Column(name = "BMI")
    private Double bmi;

    @Column(name = "SYSTOLIC_BP")
    private Double systolicBp;

    @Column(name = "DIASTOLIC_BP")
    private Double diastolicBp;

    @Column(name = "PULSE_RATE")
    private Double pulseRate;

    @Column(name = "PULSE_OXIMETER")
    private Double pulseOximeter;

    @Column(name = "COMMENTS")
    private String comments;

    @Column(name = "COMMENTS1")
    private String comments1;

    @Column(name = "COMMENTS2")
    private String comments2;

    @Column(name = "COMMENTS3")
    private String comments3;

    @Column(name = "CREATION_USER_ID")
    private String createdBy;

    @Column(name = "CREATION_TS")
    private Timestamp createdAt;

    @Column(name = "LAST_UPDATE_USER_ID")
    private String updatedBy;

    @Column(name = "LAST_UPDATE_TS")
    private Timestamp updatedAt;

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

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public String getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }

    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }
}