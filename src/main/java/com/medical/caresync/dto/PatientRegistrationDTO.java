package com.medical.caresync.dto;

import lombok.Data;

import java.util.List;
@Data

public class PatientRegistrationDTO {
    private Long tblPatientId;
    private String mrNumber;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Integer age;
    private Double weight;
    private String mobileNumber;
    private String gender;
    private String bloodGroup;
    private String maritalStatus;
    private String patientImage;
    private List<PatientAddressDTO> patientAddressesList;

    // Getters and setters
}
