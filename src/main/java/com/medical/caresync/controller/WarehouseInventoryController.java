package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouse-inventory")
public class WarehouseInventoryController {

    @GetMapping
    public String getStatus() {
        return "WarehouseInventory Controller is active";
    }
}
