package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/green-channel-consultation")
public class GreenChannelConsultationController {

    @GetMapping
    public String getStatus() {
        return "GreenChannelConsultation Controller is active";
    }
}
