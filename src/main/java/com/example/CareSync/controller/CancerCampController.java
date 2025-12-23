package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cancer-camp")
public class CancerCampController {

    @GetMapping
    public String getStatus() {
        return "CancerCamp Controller is active";
    }
}
