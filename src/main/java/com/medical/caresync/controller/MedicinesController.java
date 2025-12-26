package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines")
public class MedicinesController {

    @GetMapping
    public String getStatus() {
        return "Medicines Controller is active";
    }
}
