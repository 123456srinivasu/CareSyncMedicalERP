package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines-report")
public class MedicinesReportController {

    @GetMapping
    public String getStatus() {
        return "MedicinesReport Controller is active";
    }
}
