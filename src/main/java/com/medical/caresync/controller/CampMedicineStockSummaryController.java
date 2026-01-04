package com.medical.caresync.controller;

import com.medical.caresync.entities.CampMedicineStockSummary;
import com.medical.caresync.service.CampMedicineStockSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/camp-medicine-stock-summary")
public class CampMedicineStockSummaryController {

    @Autowired
    private CampMedicineStockSummaryService service;

    @GetMapping
    public ResponseEntity<List<CampMedicineStockSummary>> getAllSummaries() {
        return ResponseEntity.ok(service.getAllSummaries());
    }

    @GetMapping("/camp/{campId}")
    public ResponseEntity<List<CampMedicineStockSummary>> getSummariesByCampId(@PathVariable Long campId) {
        List<CampMedicineStockSummary> summaries = service.getSummariesByCampId(campId);
        return ResponseEntity.ok(summaries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampMedicineStockSummary> getSummaryById(@PathVariable Long id) {
        Optional<CampMedicineStockSummary> summary = service.getSummaryById(id);
        return summary.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

