package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/donations-report")
public class DonationsReportController {

    @GetMapping
    public String getStatus() {
        return "DonationsReport Controller is active";
    }
}
