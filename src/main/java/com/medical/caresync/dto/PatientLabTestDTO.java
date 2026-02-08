package com.medical.caresync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientLabTestDTO {
    private Long labTestLookupId;
    private String labTestDate;
    private String testWithMedicineS;
    private String testResultValue;
    private String testResultUnit;
    private String referenceValue;
    private String remark;
}
