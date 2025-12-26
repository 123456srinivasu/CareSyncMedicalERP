package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cancer-camp-result")
public class CancerCampResultController {

    @GetMapping
    public String getStatus() {
        return "CancerCampResult Controller is active";
    }
}
