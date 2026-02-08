package com.medical.caresync.controller;

import com.medical.caresync.dto.CampPatientAnswerRequestDTO;
import com.medical.caresync.dto.CampPatientAnswerResponseDTO;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.service.CampPatientAnswerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/camp-patient-answers")
public class CampPatientAnswerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampPatientAnswerController.class);

    @Autowired
    private CampPatientAnswerService campPatientAnswerService;

    @PostMapping
    public ResponseEntity<?> savePatientAnswers(@Valid @RequestBody CampPatientAnswerRequestDTO requestDTO) {
        try {
            LOGGER.info("Received request to save patient answers for campId: {}, patientId: {}", 
                    requestDTO.getCampId(), requestDTO.getPatientId());
            
            CampPatientAnswerResponseDTO response = campPatientAnswerService.savePatientAnswers(requestDTO);
            
            LOGGER.info("Successfully saved patient answers for campId: {}, patientId: {}", 
                    requestDTO.getCampId(), requestDTO.getPatientId());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (BadRequestException ex) {
            LOGGER.error("Validation error while saving patient answers: {}", ex.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        } catch (Exception e) {
            LOGGER.error("Error saving patient answers", e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }
}
