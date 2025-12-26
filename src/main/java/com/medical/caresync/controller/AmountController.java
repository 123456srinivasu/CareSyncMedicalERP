package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/amount")
public class AmountController {

    @GetMapping
    public String getStatus() {
        return "Amount Controller is active";
    }
}
