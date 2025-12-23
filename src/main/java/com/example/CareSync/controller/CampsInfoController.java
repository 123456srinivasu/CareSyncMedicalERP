package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/camps-info")
public class CampsInfoController {

    @GetMapping
    public String getStatus() {
        return "CampsInfo Controller is active";
    }
}
