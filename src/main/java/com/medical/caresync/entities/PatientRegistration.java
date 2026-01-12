package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@Entity
@Table(name = "tbl_patient_registration")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientRegistration extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBL_PATIENT_ID")
    private Long tblPatientId;


    @Column(name = "MR_NUMBER", unique = true, nullable = false)
    private String mrNumber;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FATHER_NAME")
    private String fatherName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BLOOD_GROUP")
    private String bloodGroup;

    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;

    @Column(name = "PATIENT_IMAGE")
    private String patientImage;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private List<PatientAddress> patientAddressesList;

}
