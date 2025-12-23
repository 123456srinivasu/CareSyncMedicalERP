package com.example.caresync.controller;

import com.example.caresync.dto.PatientDTO;
import com.example.caresync.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	private final PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@GetMapping
	public ResponseEntity<List<PatientDTO>> getAllPatients() {
		List<PatientDTO> patients = patientService.getAllPatients();
		return ResponseEntity.ok(patients);
	}
}
