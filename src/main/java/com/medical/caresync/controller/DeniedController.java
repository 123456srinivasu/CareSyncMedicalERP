package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/denied")
public class DeniedController {

    @GetMapping
    public String getStatus() {
        return "Denied Controller is active";
    }
}
