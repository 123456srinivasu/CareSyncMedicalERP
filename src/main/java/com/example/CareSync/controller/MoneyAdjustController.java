package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/money-adjust")
public class MoneyAdjustController {

    @GetMapping
    public String getStatus() {
        return "MoneyAdjust Controller is active";
    }
}
