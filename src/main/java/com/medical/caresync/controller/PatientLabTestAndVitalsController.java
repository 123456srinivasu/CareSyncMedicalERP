package com.medical.caresync.controller;

import com.medical.caresync.dto.PatientLabTestAndVitalsRequestDTO;
import com.medical.caresync.dto.PatientLabTestAndVitalsResponseDTO;
import com.medical.caresync.service.PatientLabTestAndVitalsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient-records")
@Tag(name = "Patient Lab Tests and Vitals", description = "APIs for managing patient lab tests and vitals")
public class PatientLabTestAndVitalsController {

    @Autowired
    private PatientLabTestAndVitalsService labTestAndVitalsService;

    @PostMapping("/save-lab-tests-and-vitals")
    @Operation(summary = "Save lab tests and vitals", description = "Save multiple lab tests and vitals for a patient visit in a single request")
    public ResponseEntity<PatientLabTestAndVitalsResponseDTO> saveLabTestsAndVitals(
            @RequestBody PatientLabTestAndVitalsRequestDTO requestDTO) {
        try {
            PatientLabTestAndVitalsResponseDTO response = labTestAndVitalsService.saveLabTestsAndVitals(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException e) {
            PatientLabTestAndVitalsResponseDTO errorResponse = new PatientLabTestAndVitalsResponseDTO(
                    false, "Error: " + e.getMessage(), 0, 0);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            PatientLabTestAndVitalsResponseDTO errorResponse = new PatientLabTestAndVitalsResponseDTO(
                    false, "An error occurred while saving data", 0, 0);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
