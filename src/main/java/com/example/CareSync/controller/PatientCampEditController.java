package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-camp-edit")
public class PatientCampEditController {

    @GetMapping
    public String getStatus() {
        return "PatientCampEdit Controller is active";
    }
}
