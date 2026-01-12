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
    private String villageName;

    private LookupDTO state;
    private LookupDTO district;
    private LookupDTO mandal;

    @Data
    public static class LookupDTO {
        private Long id;
        private String name;
    }
}
