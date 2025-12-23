package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/camp-irregular-patients")
public class CampIrregularPatientsController {

    @GetMapping
    public String getStatus() {
        return "CampIrregularPatients Controller is active";
    }
}
