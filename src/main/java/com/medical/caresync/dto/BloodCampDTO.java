package com.medical.caresync.dto;

import java.util.Date;

public class BloodCampDTO {
    private Integer id;
    private String patientName;
    private Integer age;
    private Date dateOfBirth;
    private String gender;
    private String mobileNumber;
    private String bloodGroup;
    private String maritalStatus;
    private String fatherName;
    private String city;
    private String zipCode;
    
    // Vitals
    private Double height;
    private Double weight;
    private Double bmi;
    private Double systolicBp;
    private Double diastolicBp;
    private Double pulseRate;
    private Double pulseOximeter;
    
    private Integer campId;
    private Date campDate;

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
}