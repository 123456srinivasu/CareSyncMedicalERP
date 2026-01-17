package com.medical.caresync.controller;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import com.medical.caresync.dto.PatientRegistrationDTO;
import com.medical.caresync.service.PatientRegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient-registration")
@Tag(name = "Patient Registration", description = "APIs for Patient Registration management")
public class PatientRegistrationController {
    @Autowired
    private PatientRegistrationService patientRegistrationService;

    @Operation(summary = "Create a new patient registration")
    @PostMapping
    public ResponseEntity<PatientRegistrationDTO> create(@RequestBody PatientRegistrationDTO dto) {
        return ResponseEntity.ok(patientRegistrationService.create(dto));
    }

    @Operation(summary = "Update patient registration by ID")
    @PutMapping("/{id}")
    public ResponseEntity<PatientRegistrationDTO> update(@PathVariable Long id, @RequestBody PatientRegistrationDTO dto) {
        return ResponseEntity.ok(patientRegistrationService.update(id, dto));
    }

    @Operation(summary = "Delete patient registration by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientRegistrationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get patient registration by ID")
    @GetMapping("/{id}")
    public ResponseEntity<PatientRegistrationDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(patientRegistrationService.getById(id));
    }

    @Operation(summary = "Get all patient registrations")
    @GetMapping
    public ResponseEntity<List<PatientRegistrationDTO>> getAll() {
        return ResponseEntity.ok(patientRegistrationService.getAll());
    }

    @Operation(summary = "Search patient registrations by name, MR number, or mobile number")
    @GetMapping("/search")
    public ResponseEntity<List<PatientRegistrationDTO>> searchPatients(
            @RequestParam String searchPatient) {
        return ResponseEntity.ok(patientRegistrationService.searchPatients(searchPatient));
    }

    @Operation(summary = "Create a new patient registration with image upload")
    @PostMapping("/with-image")
    public ResponseEntity<PatientRegistrationDTO> createWithImage(
            @RequestPart("patient") PatientRegistrationDTO dto,
            @RequestPart("image") MultipartFile image) throws IOException {
        dto.setPatientImage(image.getBytes());
        return ResponseEntity.ok(dto.getTblPatientId() != null ? patientRegistrationService.update(dto.getTblPatientId(), dto) :  patientRegistrationService.create(dto));
    }
}
