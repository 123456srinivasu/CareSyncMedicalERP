package com.medical.caresync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientVitalDTO {
    private Long vitalLookupId;
    private String measurementType;
    private String vitalValue;
}
