package com.medical.caresync.controller;

import com.medical.caresync.dto.CampMedicineStockSummaryResponseDTO;
import com.medical.caresync.entities.CampMedicineStockSummary;
import com.medical.caresync.service.CampMedicineStockSummaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/camp-medicine-stock-summary")
public class CampMedicineStockSummaryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampMedicineStockSummaryController.class);

    @Autowired
    private CampMedicineStockSummaryService service;

    @GetMapping
    public ResponseEntity<List<CampMedicineStockSummary>> getAllSummaries() {
        return ResponseEntity.ok(service.getAllSummaries());
    }

    @GetMapping("/camp/{campId}")
    public ResponseEntity<List<CampMedicineStockSummaryResponseDTO>> getMedicinesByCampId(@PathVariable Long campId) {
        try {
            LOGGER.info("Received request to fetch medicines for camp ID: {}", campId);
            List<CampMedicineStockSummaryResponseDTO> medicines = service.getMedicinesByCampId(campId);
            LOGGER.info("Successfully fetched {} medicines for camp ID: {}", medicines.size(), campId);
            return ResponseEntity.ok(medicines);
        } catch (Exception e) {
            LOGGER.error("Error fetching medicines for camp ID: {}", campId, e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampMedicineStockSummary> getSummaryById(@PathVariable Long id) {
        Optional<CampMedicineStockSummary> summary = service.getSummaryById(id);
        return summary.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


