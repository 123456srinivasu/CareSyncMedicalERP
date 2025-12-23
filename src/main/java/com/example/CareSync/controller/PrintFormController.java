package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/print-form")
public class PrintFormController {

    @GetMapping
    public String getStatus() {
        return "PrintForm Controller is active";
    }
}
