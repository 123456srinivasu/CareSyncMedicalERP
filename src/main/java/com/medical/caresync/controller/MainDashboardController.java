package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main-dashboard")
public class MainDashboardController {

    @GetMapping
    public String getStatus() {
        return "MainDashboard Controller is active";
    }
}
