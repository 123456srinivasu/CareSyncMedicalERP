package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diagnosis-report")
public class DiagnosisReportController {

    @GetMapping
    public String getStatus() {
        return "DiagnosisReport Controller is active";
    }
}
