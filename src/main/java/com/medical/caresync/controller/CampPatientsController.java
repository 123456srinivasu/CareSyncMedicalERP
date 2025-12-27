package com.medical.caresync.controller;

import com.medical.caresync.dto.CampPatientDTO;
import com.medical.caresync.service.CampPatientsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/camp-patients")
public class CampPatientsController {

    @Autowired
    private CampPatientsService service;
    @GetMapping("/search")
    public List<CampPatientDTO> search(@RequestParam String query, @RequestParam Integer campId) {
        return service.searchPatients(query, campId);
    }
    @GetMapping("/{id}")
    public CampPatientDTO getPatient(@PathVariable Long id) {
        return service.getPatientById(id);
    }
}
