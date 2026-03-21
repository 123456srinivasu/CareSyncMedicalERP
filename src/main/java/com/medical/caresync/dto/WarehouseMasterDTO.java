package com.medical.caresync.dto;

import lombok.Data;

@Data
public class WarehouseMasterDTO {

    private Long id;
    private String warehouseCode;
    private String warehouseName;
    private String address;
    private String city;
    private String postalCode;
    
    private Long stateId;
    private String stateName;

    private Long districtId;
    private String districtName;

    private Long mandalId;
    private String mandalName;

    private String contactPerson;
    private String contactNumber;
    private String emailAddress;
    private Boolean isActive;
}
