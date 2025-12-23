package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/camp-patients")
public class CampPatientsController {

    @GetMapping
    public String getStatus() {
        return "CampPatients Controller is active";
    }
}
