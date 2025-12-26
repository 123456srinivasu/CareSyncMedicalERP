package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search-patients-for-tiffa")
public class SearchPatientsForTiffaController {

    @GetMapping
    public String getStatus() {
        return "SearchPatientsForTiffa Controller is active";
    }
}
