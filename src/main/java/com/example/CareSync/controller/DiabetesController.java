package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diabetes")
public class DiabetesController {

    @GetMapping
    public String getStatus() {
        return "Diabetes Controller is active";
    }
}
