package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/create-camp")
public class CreateCampController {

    @GetMapping
    public String getStatus() {
        return "CreateCamp Controller is active";
    }
}
