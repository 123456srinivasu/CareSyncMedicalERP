package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cardiology")
public class CardiologyController {

    @GetMapping
    public String getStatus() {
        return "Cardiology Controller is active";
    }
}
