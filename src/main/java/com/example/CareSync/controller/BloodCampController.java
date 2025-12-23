package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blood-camp")
public class BloodCampController {

    @GetMapping
    public String getStatus() {
        return "BloodCamp Controller is active";
    }
}
