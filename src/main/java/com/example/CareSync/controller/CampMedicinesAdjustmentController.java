package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/camp-medicines-adjustment")
public class CampMedicinesAdjustmentController {

    @GetMapping
    public String getStatus() {
        return "CampMedicinesAdjustment Controller is active";
    }
}
