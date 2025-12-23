package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/veterinary-registration")
public class VeterinaryRegistrationController {

    @GetMapping
    public String getStatus() {
        return "VeterinaryRegistration Controller is active";
    }
}
