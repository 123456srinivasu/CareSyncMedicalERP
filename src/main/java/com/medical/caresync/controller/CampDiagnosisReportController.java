package com.medical.caresync.controller;

import com.medical.caresync.dto.CampDiagnosisReportDTO;
import com.medical.caresync.service.CampDiagnosisReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/camp-diagnosis-report")
public class CampDiagnosisReportController {

   @Autowired
    private CampDiagnosisReportService campDiagnosisReportService;
    @GetMapping("/search")
    public List<CampDiagnosisReportDTO> getReport(@RequestParam String diagnosis, @RequestParam(required = false) Integer campId) {
        return campDiagnosisReportService.getReportByDiagnosis(diagnosis, campId);
    }
}
