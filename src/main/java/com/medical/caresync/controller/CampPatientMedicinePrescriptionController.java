package com.medical.caresync.controller;

import com.medical.caresync.dto.CampPatientMedicinePrescriptionRequestDTO;
import com.medical.caresync.dto.CampPatientMedicinePrescriptionResponseDTO;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.service.CampPatientMedicinePrescriptionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/camp-patient-medicine-prescription")
public class CampPatientMedicinePrescriptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampPatientMedicinePrescriptionController.class);

    @Autowired
    private CampPatientMedicinePrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<?> createPrescription(@Valid @RequestBody CampPatientMedicinePrescriptionRequestDTO requestDTO) {
        try {
            LOGGER.info("Received request to create prescription for campId: {}, patientId: {}, medicineId: {}", 
                    requestDTO.getCampId(), requestDTO.getPatientId(), requestDTO.getMedicineId());

            CampPatientMedicinePrescriptionResponseDTO response = prescriptionService.savePrescription(requestDTO);

            LOGGER.info("Successfully created prescription with ID: {}", response.getPrescriptionId());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (BadRequestException ex) {
            LOGGER.error("Validation error while creating prescription: {}", ex.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        } catch (Exception e) {
            LOGGER.error("Error creating prescription", e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }

    @PutMapping("/{prescriptionId}")
    public ResponseEntity<?> updatePrescription(@PathVariable Long prescriptionId,
                                                 @Valid @RequestBody CampPatientMedicinePrescriptionRequestDTO requestDTO) {
        try {
            LOGGER.info("Received request to update prescription ID: {}", prescriptionId);

            CampPatientMedicinePrescriptionResponseDTO response = prescriptionService.updatePrescription(prescriptionId, requestDTO);

            LOGGER.info("Successfully updated prescription ID: {}", prescriptionId);

            return ResponseEntity.ok(response);
        } catch (BadRequestException ex) {
            LOGGER.error("Validation error while updating prescription: {}", ex.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        } catch (Exception e) {
            LOGGER.error("Error updating prescription ID: {}", prescriptionId, e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }

    @GetMapping("/{prescriptionId}")
    public ResponseEntity<?> getPrescriptionById(@PathVariable Long prescriptionId) {
        try {
            LOGGER.info("Received request to fetch prescription ID: {}", prescriptionId);

            CampPatientMedicinePrescriptionResponseDTO response = prescriptionService.getPrescriptionById(prescriptionId);

            LOGGER.info("Successfully fetched prescription ID: {}", prescriptionId);

            return ResponseEntity.ok(response);
        } catch (BadRequestException ex) {
            LOGGER.error("Prescription not found: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
        } catch (Exception e) {
            LOGGER.error("Error fetching prescription ID: {}", prescriptionId, e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<?> getPrescriptionsByPatientId(@PathVariable Long patientId) {
        try {
            LOGGER.info("Received request to fetch prescriptions for patient ID: {}", patientId);

            List<CampPatientMedicinePrescriptionResponseDTO> prescriptions = prescriptionService.getPrescriptionsByPatientId(patientId);

            LOGGER.info("Successfully fetched {} prescriptions for patient ID: {}", prescriptions.size(), patientId);

            return ResponseEntity.ok(prescriptions);
        } catch (Exception e) {
            LOGGER.error("Error fetching prescriptions for patient ID: {}", patientId, e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }

    @GetMapping("/camp/{campId}")
    public ResponseEntity<?> getPrescriptionsByCampId(@PathVariable Long campId) {
        try {
            LOGGER.info("Received request to fetch prescriptions for camp ID: {}", campId);

            List<CampPatientMedicinePrescriptionResponseDTO> prescriptions = prescriptionService.getPrescriptionsByCampId(campId);

            LOGGER.info("Successfully fetched {} prescriptions for camp ID: {}", prescriptions.size(), campId);

            return ResponseEntity.ok(prescriptions);
        } catch (Exception e) {
            LOGGER.error("Error fetching prescriptions for camp ID: {}", campId, e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }
}
