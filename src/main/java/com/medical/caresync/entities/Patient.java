package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "tbl_patient")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBL_PATIENT_ID")
    private Long tblPatientId;


    @Column(name = "MR_NUMBER", unique = true, nullable = false)
    private String mrNumber;

    @Column(name = "FIRST_NAME")
    private String firstNm;

    @Column(name = "LAST_NAME")
    private String lastNm;

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

    @Column(name = "DOB")
    private LocalDate dob;

    @Lob
    @Column(name = "PATIENT_IMAGE", columnDefinition = "LONGBLOB")
    private byte[] patientImage;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "TBL_PATIENT_ID")
    private List<PatientAddress> patientAddressesList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PatientCamp> patientCamps;

}
