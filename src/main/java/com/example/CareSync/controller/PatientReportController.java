package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-report")
public class PatientReportController {

    @GetMapping
    public String getStatus() {
        return "PatientReport Controller is active";
    }
}
