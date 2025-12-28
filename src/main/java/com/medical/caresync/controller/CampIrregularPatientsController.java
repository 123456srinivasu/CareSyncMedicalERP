package com.medical.caresync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.medical.caresync.dto.CampIrregularPatientsDTO;
import com.medical.caresync.service.CampIrregularPatientsService;

@RestController
@RequestMapping("/api/camp-irregular-patients")
public class CampIrregularPatientsController {

    @Autowired
	private CampIrregularPatientsService campIrregularPatientsService;
	@GetMapping
	public List<CampIrregularPatientsDTO> getIrregularPatients(@RequestParam Integer campId) {
		return campIrregularPatientsService.getIrregularPatients(campId);
	}
}
