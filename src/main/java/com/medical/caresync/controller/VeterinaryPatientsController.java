package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veterinary-patients")
public class VeterinaryPatientsController {

    @GetMapping
    public String getStatus() {
        return "VeterinaryPatients Controller is active";
    }
}
