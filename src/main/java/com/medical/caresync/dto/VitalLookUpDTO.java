package com.medical.caresync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VitalLookUpDTO {
    private Long vitalId;
    private String vitalName;
    private String referenceRange;
    private String description;
    private Boolean isActive;

}
