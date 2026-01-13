package com.medical.caresync.controller;

import com.medical.caresync.dto.PatientChiefComplaintDTO;
import com.medical.caresync.service.PatientChiefComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient-chief-complaints")
public class PatientChiefComplaintController {

    @Autowired
    PatientChiefComplaintService service;

    // SAVE or UPDATE
    @PutMapping("/by-consultation")
    public ResponseEntity<PatientChiefComplaintDTO> saveOrUpdate(
            @RequestParam Long patientConsultationId,
            @RequestBody PatientChiefComplaintDTO dto) {

        return ResponseEntity.ok(
                service.saveOrUpdateByConsultationId(patientConsultationId, dto)
        );
    }

    @PostMapping
    public ResponseEntity<PatientChiefComplaintDTO> create(
            @RequestBody PatientChiefComplaintDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientChiefComplaintDTO> update(
            @PathVariable Long id,
            @RequestBody PatientChiefComplaintDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientChiefComplaintDTO> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PatientChiefComplaintDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
