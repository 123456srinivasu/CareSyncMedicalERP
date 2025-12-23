package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diet-counselling")
public class DietCounsellingController {

    @GetMapping
    public String getStatus() {
        return "DietCounselling Controller is active";
    }
}
