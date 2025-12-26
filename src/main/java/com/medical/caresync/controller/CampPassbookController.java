package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/camp-passbook")
public class CampPassbookController {

    @GetMapping
    public String getStatus() {
        return "CampPassbook Controller is active";
    }
}
