package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.medical.caresync.dto.CampMedicinesAdjustmentDTO;
import com.medical.caresync.service.CampMedicinesAdjustmentService;

import java.util.List;

@RestController
@RequestMapping("/api/camp-medicines-adjustment")
public class CampMedicinesAdjustmentController {

    @Autowired
    private CampMedicinesAdjustmentService service;
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody List<CampMedicinesAdjustmentDTO> adjustmentDTOs) {
        service.saveAll(adjustmentDTOs);
        return ResponseEntity.ok("Camp medicines adjustments saved successfully.");
    }
    @GetMapping("/camp/{campDetailsId}")
    public ResponseEntity<List<CampMedicinesAdjustmentDTO>> getByCampDetailsId(@PathVariable Long campDetailsId) {
        return ResponseEntity.ok(service.getByCampDetailsId(campDetailsId));
    }
}
