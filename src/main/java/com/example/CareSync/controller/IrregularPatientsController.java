package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/irregular-patients")
public class IrregularPatientsController {

    @GetMapping
    public String getStatus() {
        return "IrregularPatients Controller is active";
    }
}
