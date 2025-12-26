package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/donations")
public class DonationsController {

    @GetMapping
    public String getStatus() {
        return "Donations Controller is active";
    }
}
