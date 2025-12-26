package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tiffa-scan-patients")
public class TiffaScanPatientsController {

    @GetMapping
    public String getStatus() {
        return "TiffaScanPatients Controller is active";
    }
}
