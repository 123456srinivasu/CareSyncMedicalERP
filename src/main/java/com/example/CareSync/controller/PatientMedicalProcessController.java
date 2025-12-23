package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-medical-process")
public class PatientMedicalProcessController {

    @GetMapping
    public String getStatus() {
        return "PatientMedicalProcess Controller is active";
    }
}
