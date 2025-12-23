package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-insulin")
public class PatientInsulinController {

    @GetMapping
    public String getStatus() {
        return "PatientInsulin Controller is active";
    }
}
