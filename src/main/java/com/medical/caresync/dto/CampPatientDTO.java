package com.medical.caresync.dto;


import java.util.Date;
import java.io.Serializable;

public class CampPatientDTO implements Serializable {
private Long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String mobileNumber;
    private Integer age;
    private String gender;
    private String mrNumber;
    private String oldMrNumber;
    private String newMrNumber;
    private String village;
    private String photoPath;
    private Date dob;
    private String aadharNumber;
    private String bloodGroup;
    private String maritalStatus;
    private String address;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }
    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getMrNumber() { return mrNumber; }
    public void setMrNumber(String mrNumber) { this.mrNumber = mrNumber; }
    public String getOldMrNumber() { return oldMrNumber; }
    public void setOldMrNumber(String oldMrNumber) { this.oldMrNumber = oldMrNumber; }
    public String getNewMrNumber() { return newMrNumber; }
    public void setNewMrNumber(String newMrNumber) { this.newMrNumber = newMrNumber; }
    public String getVillage() { return village; }
    public void setVillage(String village) { this.village = village; }
    public String getPhotoPath() { return photoPath; }
    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public String getAadharNumber() { return aadharNumber; }
    public void setAadharNumber(String aadharNumber) { this.aadharNumber = aadharNumber; }
    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
