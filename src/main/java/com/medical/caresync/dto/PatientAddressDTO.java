package com.medical.caresync.dto;

import lombok.Data;

@Data
public class PatientAddressDTO {
    private Long addressId;
    private String addressLine;
    private String city;
    private Long stateId;
    private Long districtId;
    private Long mandalId;
    private String postalCode;
    // Getters and setters
}
