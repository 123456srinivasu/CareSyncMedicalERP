package com.medical.caresync.controller;

import com.medical.caresync.dto.AssessmentNotesRequestDTO;
import com.medical.caresync.dto.AssessmentNotesResponseDTO;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.service.CampPatientAssessmentNotesService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/camp-patient-assessment-notes")
public class CampPatientAssessmentNotesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampPatientAssessmentNotesController.class);

    @Autowired
    private CampPatientAssessmentNotesService assessmentNotesService;

    @PostMapping
    public ResponseEntity<?> saveAssessmentNotes(@Valid @RequestBody AssessmentNotesRequestDTO requestDTO) {
        try {
            LOGGER.info("Received request to save assessment notes for campId: {}, patientId: {}", 
                    requestDTO.getCampId(), requestDTO.getPatientId());
            
            AssessmentNotesResponseDTO response = assessmentNotesService.saveAssessmentNotes(requestDTO);
            
            LOGGER.info("Successfully saved assessment notes for campId: {}, patientId: {}", 
                    requestDTO.getCampId(), requestDTO.getPatientId());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (BadRequestException ex) {
            LOGGER.error("Validation error while saving assessment notes: {}", ex.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        } catch (Exception e) {
            LOGGER.error("Error saving assessment notes", e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }
}
