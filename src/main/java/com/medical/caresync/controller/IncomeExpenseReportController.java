package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/income-expense-report")
public class IncomeExpenseReportController {

    @GetMapping
    public String getStatus() {
        return "IncomeExpenseReport Controller is active";
    }
}
