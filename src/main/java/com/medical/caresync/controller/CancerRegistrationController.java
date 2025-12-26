package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cancer-registration")
public class CancerRegistrationController {

    @GetMapping
    public String getStatus() {
        return "CancerRegistration Controller is active";
    }
}
