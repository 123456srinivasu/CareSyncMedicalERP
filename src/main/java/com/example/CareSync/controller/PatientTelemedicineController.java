package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-telemedicine")
public class PatientTelemedicineController {

    @GetMapping
    public String getStatus() {
        return "PatientTelemedicine Controller is active";
    }
}
