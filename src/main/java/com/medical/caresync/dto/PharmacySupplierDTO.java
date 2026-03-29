package com.medical.caresync.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PharmacySupplierDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long pharmacySupplierId;
    private String supplierCode;
    private String supplierName;
    private String contactName;
    private String contactEmail;
    private String street;
    private String city;
    private String state;
    private String pincode;
    private Boolean isActive;
}
