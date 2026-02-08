package com.medical.caresync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientLabTestAndVitalsResponseDTO {
    private boolean success;
    private String message;
    private int labTestsSaved;
    private int vitalsSaved;
}
