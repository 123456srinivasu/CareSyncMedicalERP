package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cash-management")
public class CashManagementController {

    @GetMapping
    public String getStatus() {
        return "CashManagement Controller is active";
    }
}
