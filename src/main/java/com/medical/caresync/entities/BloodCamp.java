package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "cancer_screening_manipal")
public class BloodCamp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CANCER_SCREENING_MANIPAL_ID")
    private Integer id;

    @Column(name = "PATIENT_NM")
    private String patientName;

    @Column(name = "AGE")
    private Integer age;

    @Temporal(TemporalType.DATE)
    @Column(name = "DOB")
    private Date dateOfBirth;

    @Column(name = "GENDER_CD")
    private String gender;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "BLOOD_GROUP")
    private String bloodGroup;

    @Column(name = "MARITAL_STATUS_CD")
    private String maritalStatus;

    @Column(name = "FATHER_NM")
    private String fatherName;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIP_CD")
    private String zipCode;

    // Vitals
    private Double height;
    private Double weight;
    private Double bmi;

    @Column(name = "SYSTOLIC_BP")
    private Double systolicBp;

    @Column(name = "DIASTOLIC_BP")
    private Double diastolicBp;

    @Column(name = "PULSE_RATE")
    private Double pulseRate;

    @Column(name = "PULSE_OXIMETER")
    private Double pulseOximeter;

    @Column(name = "CAMP_ID")
    private Integer campId;

    @Temporal(TemporalType.DATE)
    @Column(name = "CAMP_DATE")
    private Date campDate;

    @Column(name = "CREATION_USER_ID")
    private String creationUserId;

    @Column(name = "CREATION_TS")
    private Timestamp creationTs;

    // Getters and Setters ...
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }
    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }
    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
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
    public Integer getCampId() { return campId; }
    public void setCampId(Integer campId) { this.campId = campId; }
    public Date getCampDate() { return campDate; }
    public void setCampDate(Date campDate) { this.campDate = campDate; }
    public String getCreationUserId() { return creationUserId; }
    public void setCreationUserId(String creationUserId) { this.creationUserId = creationUserId; }
    public Timestamp getCreationTs() { return creationTs; }
    public void setCreationTs(Timestamp creationTs) { this.creationTs = creationTs; }
}