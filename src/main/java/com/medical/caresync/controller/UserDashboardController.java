package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-dashboard")
public class UserDashboardController {

    @GetMapping
    public String getStatus() {
        return "UserDashboard Controller is active";
    }
}
