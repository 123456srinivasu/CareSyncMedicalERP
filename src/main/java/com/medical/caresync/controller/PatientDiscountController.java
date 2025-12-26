package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-discount")
public class PatientDiscountController {

    @GetMapping
    public String getStatus() {
        return "PatientDiscount Controller is active";
    }
}
