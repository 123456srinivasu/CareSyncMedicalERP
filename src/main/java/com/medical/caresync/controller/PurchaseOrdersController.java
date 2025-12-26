package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrdersController {

    @GetMapping
    public String getStatus() {
        return "PurchaseOrders Controller is active";
    }
}
