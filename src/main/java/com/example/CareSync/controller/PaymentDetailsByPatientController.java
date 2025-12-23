package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment-details-by-patient")
public class PaymentDetailsByPatientController {

    @GetMapping
    public String getStatus() {
        return "PaymentDetailsByPatient Controller is active";
    }
}
