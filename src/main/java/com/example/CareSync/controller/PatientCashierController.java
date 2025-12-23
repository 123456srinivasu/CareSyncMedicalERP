package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-cashier")
public class PatientCashierController {

    @GetMapping
    public String getStatus() {
        return "PatientCashier Controller is active";
    }
}
