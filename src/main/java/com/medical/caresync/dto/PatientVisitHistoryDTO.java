package com.medical.caresync.dto;

import lombok.Data;
import java.util.List;

@Data
public class PatientVisitHistoryDTO {
    private String mrNumber;
    private String patientName;
    private int totalCampsAttended;
    private List<CampVisitDTO> camps;
}
