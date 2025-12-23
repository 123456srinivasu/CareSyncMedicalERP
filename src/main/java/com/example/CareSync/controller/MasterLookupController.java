package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/master-lookup")
public class MasterLookupController {

    @GetMapping
    public String getStatus() {
        return "MasterLookup Controller is active";
    }
}
