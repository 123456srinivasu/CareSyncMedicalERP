package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-telemedicine-dashboard")
public class PatientTelemedicineDashboardController {

    @GetMapping
    public String getStatus() {
        return "PatientTelemedicineDashboard Controller is active";
    }
}
