package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharma-lookup")
public class PharmaLookupController {

    @GetMapping
    public String getStatus() {
        return "PharmaLookup Controller is active";
    }
}
