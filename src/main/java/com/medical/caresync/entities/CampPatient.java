package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tbl_patient")
public class CampPatient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_patient_id")
    private Long id;
    @Column(name = "first_nm")
    private String firstName;
    @Column(name = "last_nm")
    private String lastName;
    @Column(name = "father_nm")
    private String fatherName;
    @Column(name = "mobile_number")
    private String mobileNumber;
    private Integer age;
    @Column(name = "gender_cd")
    private String gender;
    @Column(name = "enrollment_id")
    private String mrNumber;
    @Column(name = "old_enrollment_id")
    private String oldMrNumber;
    @Column(name = "new_enrollment_id")
    private String newMrNumber;
    @Column(name = "city")
    private String village;
    @Column(name = "patient_image_path")
    private String photoPath;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "adhar_number")
    private String aadharNumber;
    @Column(name = "blood_group")
    private String bloodGroup;
    @Column(name = "marital_status_cd")
    private String maritalStatus;
    @Column(name = "address_line_1")
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
