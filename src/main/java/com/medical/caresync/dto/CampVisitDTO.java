package com.medical.caresync.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class CampVisitDTO {
    private Long campId;
    private String campName;
    private LocalDate campDate;
    private String doctorName; // Can be fetched from Users table
    private String diagnosis;
    private List<PrescribedMedicineDTO> medicines;
}
