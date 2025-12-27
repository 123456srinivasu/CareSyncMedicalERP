package com.medical.caresync.controller;

import com.medical.caresync.dto.AssetDTO;
import com.medical.caresync.service.AssetReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/asset-report")
public class AssetReportController {

    @Autowired
    private AssetReportService assetReportService;

    @GetMapping
    public List<AssetDTO> getAssetReport(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            @RequestParam("campId") Integer campId) {
        
        return assetReportService.getAssetReport(startDate, endDate, campId);
    }
}