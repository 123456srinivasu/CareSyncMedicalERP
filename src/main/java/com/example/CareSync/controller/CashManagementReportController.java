package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cash-management-report")
public class CashManagementReportController {

    @GetMapping
    public String getStatus() {
        return "CashManagementReport Controller is active";
    }
}
