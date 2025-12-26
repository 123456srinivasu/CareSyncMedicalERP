package com.medical.caresync.controller;

import com.medical.caresync.dto.PatientDTO;
import com.medical.caresync.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	public static final String PATH = "/api/patients";
	private final PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@GetMapping
	public ResponseEntity<?> getAllPatients(
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size) {
		if (page != null && size != null) {
			return ResponseEntity.ok(patientService.getPatientsPage(page, size));
		}
		List<PatientDTO> patients = patientService.getAllPatients();
		return ResponseEntity.ok(patients);
	}
}
