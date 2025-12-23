package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/camp-diagnosis-report")
public class CampDiagnosisReportController {

    @GetMapping
    public String getStatus() {
        return "CampDiagnosisReport Controller is active";
    }
}
