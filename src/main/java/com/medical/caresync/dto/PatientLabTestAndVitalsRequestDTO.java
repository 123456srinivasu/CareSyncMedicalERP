package com.medical.caresync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientLabTestAndVitalsRequestDTO {
    private Long patientId;
    private Long patientVisitId;
    private List<PatientLabTestDTO> labTests;
    private List<PatientVitalDTO> vitals;
}
