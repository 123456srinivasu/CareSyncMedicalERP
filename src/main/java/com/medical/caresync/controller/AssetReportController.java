package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asset-report")
public class AssetReportController {

    @GetMapping
    public String getStatus() {
        return "AssetReport Controller is active";
    }
}
