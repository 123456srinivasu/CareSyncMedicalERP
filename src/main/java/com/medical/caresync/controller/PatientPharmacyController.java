package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-pharmacy")
public class PatientPharmacyController {

    @GetMapping
    public String getStatus() {
        return "PatientPharmacy Controller is active";
    }
}
