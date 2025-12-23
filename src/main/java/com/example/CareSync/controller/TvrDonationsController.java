package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tvr-donations")
public class TvrDonationsController {

    @GetMapping
    public String getStatus() {
        return "TvrDonations Controller is active";
    }
}
