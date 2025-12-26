package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses-report")
public class ExpensesReportController {

    @GetMapping
    public String getStatus() {
        return "ExpensesReport Controller is active";
    }
}
