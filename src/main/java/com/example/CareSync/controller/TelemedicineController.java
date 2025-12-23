package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/telemedicine")
public class TelemedicineController {

    @GetMapping
    public String getStatus() {
        return "Telemedicine Controller is active";
    }
}
