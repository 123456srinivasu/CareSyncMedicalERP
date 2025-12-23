package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/print-report")
public class PrintReportController {

    @GetMapping
    public String getStatus() {
        return "PrintReport Controller is active";
    }
}
