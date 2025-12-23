package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/manage-labs")
public class ManageLabsController {

    @GetMapping
    public String getStatus() {
        return "ManageLabs Controller is active";
    }
}
