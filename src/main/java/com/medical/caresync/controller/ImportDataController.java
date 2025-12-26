package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/import-data")
public class ImportDataController {

    @GetMapping
    public String getStatus() {
        return "ImportData Controller is active";
    }
}
