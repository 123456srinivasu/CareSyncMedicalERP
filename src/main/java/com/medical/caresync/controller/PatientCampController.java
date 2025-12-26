package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-camp")
public class PatientCampController {

    @GetMapping
    public String getStatus() {
        return "PatientCamp Controller is active";
    }
}
