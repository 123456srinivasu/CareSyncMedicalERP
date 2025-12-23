package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharma-lookup-report")
public class PharmaLookupReportController {

    @GetMapping
    public String getStatus() {
        return "PharmaLookupReport Controller is active";
    }
}
