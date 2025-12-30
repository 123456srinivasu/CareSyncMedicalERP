package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.caresync.dto.CampMedicinesReportSummaryDTO;
import com.medical.caresync.service.CampMedicinesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/camp-medicines-report")
public class CampMedicinesReportController {

    private final CampMedicinesReportService campMedicinesReportService;
    @Autowired
    public CampMedicinesReportController(CampMedicinesReportService campMedicinesReportService) {
        this.campMedicinesReportService = campMedicinesReportService;
    }
    @GetMapping("/by-medicine/{medicineId}")
    public ResponseEntity<CampMedicinesReportSummaryDTO> getReportByMedicine(
            @PathVariable("medicineId") Long medicineId) {

        if (medicineId == null || medicineId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        CampMedicinesReportSummaryDTO report =
                campMedicinesReportService.getReportByMedicineId(medicineId);

        if (report.getPatientMedications() == null || report.getPatientMedications().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(report);
    }
}
