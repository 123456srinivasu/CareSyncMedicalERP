package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-setup")
public class PatientSetupController {

    @GetMapping
    public String getStatus() {
        return "PatientSetup Controller is active";
    }
}
