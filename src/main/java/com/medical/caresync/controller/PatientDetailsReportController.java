package com.medical.caresync.controller;

import com.medical.caresync.dto.PatientDetailsReportDTO;
import com.medical.caresync.dto.PatientRegistrationDTO;
import com.medical.caresync.service.PatientRegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patient-details-report")
@Tag(name = "Patient Details Report", description = "APIs for Patient Details Report")
public class PatientDetailsReportController {

    @Autowired
    private PatientRegistrationService patientRegistrationService;

    @GetMapping("/list")
    @Operation(summary = "Get list of all patient details", description = "Returns a list of all patients with report details")
    public ResponseEntity<List<PatientDetailsReportDTO>> getAllPatientDetails() {
        List<PatientRegistrationDTO> patients = patientRegistrationService.getAll();
        List<PatientDetailsReportDTO> reportDTOs = patients.stream()
                .map(this::mapToReportDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reportDTOs);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get patient details by ID", description = "Returns details of a specific patient")
    public ResponseEntity<PatientDetailsReportDTO> getPatientDetailsById(@PathVariable Long id) {
        PatientRegistrationDTO patient = patientRegistrationService.getById(id);
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapToReportDTO(patient));
    }

    private PatientDetailsReportDTO mapToReportDTO(PatientRegistrationDTO dto) {
        PatientDetailsReportDTO reportDTO = new PatientDetailsReportDTO();
        reportDTO.setTblPatientId(dto.getTblPatientId());
        reportDTO.setMrNumber(dto.getMrNumber());
        reportDTO.setFirstName(dto.getFirstName());
        reportDTO.setLastName(dto.getLastName());
        reportDTO.setFatherName(dto.getFatherName());
        reportDTO.setAge(dto.getAge());
        reportDTO.setWeight(dto.getWeight());
        reportDTO.setMobileNumber(dto.getMobileNumber());
        reportDTO.setGender(dto.getGender());
        reportDTO.setBloodGroup(dto.getBloodGroup());
        reportDTO.setMaritalStatus(dto.getMaritalStatus());
        reportDTO.setPatientAddressesList(dto.getPatientAddressesList());
        return reportDTO;
    }
}
