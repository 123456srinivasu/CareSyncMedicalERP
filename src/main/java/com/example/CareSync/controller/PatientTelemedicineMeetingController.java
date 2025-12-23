package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient-telemedicine-meeting")
public class PatientTelemedicineMeetingController {

    @GetMapping
    public String getStatus() {
        return "PatientTelemedicineMeeting Controller is active";
    }
}
