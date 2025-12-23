package com.example.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouse-to-company")
public class WarehouseToCompanyController {

    @GetMapping
    public String getStatus() {
        return "WarehouseToCompany Controller is active";
    }
}
