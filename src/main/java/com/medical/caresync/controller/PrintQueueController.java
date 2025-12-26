package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/print-queue")
public class PrintQueueController {

    @GetMapping
    public String getStatus() {
        return "PrintQueue Controller is active";
    }
}
