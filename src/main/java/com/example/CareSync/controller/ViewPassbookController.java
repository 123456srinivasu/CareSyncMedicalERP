package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/view-passbook")
public class ViewPassbookController {

    @GetMapping
    public String getStatus() {
        return "ViewPassbook Controller is active";
    }
}
