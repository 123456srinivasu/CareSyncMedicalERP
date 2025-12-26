package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blood-camp-results")
public class BloodCampResultsController {

    @GetMapping
    public String getStatus() {
        return "BloodCampResults Controller is active";
    }
}
