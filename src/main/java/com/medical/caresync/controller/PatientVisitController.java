package com.medical.caresync.controller;

import com.medical.caresync.dto.PatientVisitHistoryDTO;
import com.medical.caresync.service.PatientVisitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient Visits", description = "Patient Visit History APIs")
public class PatientVisitController {

    @Autowired
    private PatientVisitService patientVisitService;

    @GetMapping("/mr/{mrNumber}/visits")
    @Operation(summary = "Get patient visit history", description = "Returns detailed visit history for a patient including camp and medicine details")
    public ResponseEntity<PatientVisitHistoryDTO> getPatientVisits(@PathVariable String mrNumber) {
        PatientVisitHistoryDTO history = patientVisitService.getPatientVisitHistory(mrNumber);
        if (history == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(history);
    }
}
