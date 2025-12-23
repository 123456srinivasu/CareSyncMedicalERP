package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-patient-search")
public class UserPatientSearchController {

    @GetMapping
    public String getStatus() {
        return "UserPatientSearch Controller is active";
    }
}
