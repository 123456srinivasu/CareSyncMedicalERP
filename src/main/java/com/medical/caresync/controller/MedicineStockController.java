package com.medical.caresync.controller;

import com.medical.caresync.entities.MedicineStock;
import com.medical.caresync.service.MedicineStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicine-stock")
public class MedicineStockController {

    @Autowired
    private MedicineStockService service;

    @GetMapping
    public ResponseEntity<List<MedicineStock>> getAllStocks() {
        return ResponseEntity.ok(service.getAllStocks());
    }

    @GetMapping("/active")
    public ResponseEntity<List<MedicineStock>> getActiveStocks() {
        return ResponseEntity.ok(service.getActiveStocks());
    }

    @GetMapping("/medication/{medicationId}")
    public ResponseEntity<List<MedicineStock>> getStocksByMedication(@PathVariable Long medicationId) {
        return ResponseEntity.ok(service.getStocksByMedication(medicationId));
    }

    @GetMapping("/invoice/{invoiceId}")
    public ResponseEntity<List<MedicineStock>> getStocksByInvoice(@PathVariable Long invoiceId) {
        return ResponseEntity.ok(service.getStocksByInvoice(invoiceId));
    }

    @GetMapping("/camp/{campId}")
    public ResponseEntity<List<MedicineStock>> getStocksByCamp(@PathVariable Long campId) {
        return ResponseEntity.ok(service.getStocksByCamp(campId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineStock> getStockById(@PathVariable Long id) {
        Optional<MedicineStock> stock = service.getStockById(id);
        return stock.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createStock(@RequestBody MedicineStock stock) {
        try {
            MedicineStock createdStock = service.createStock(stock);
            return ResponseEntity.ok(createdStock);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating stock: " + e.getMessage());
        }
    }

    @PostMapping("/batch")
    public ResponseEntity<?> createStocks(@RequestBody List<MedicineStock> stocks) {
        try {
            if (stocks == null || stocks.isEmpty()) {
                return ResponseEntity.badRequest().body("Stock list cannot be empty");
            }
            List<MedicineStock> createdStocks = service.createStocks(stocks);
            return ResponseEntity.ok(createdStocks);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating stocks: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStock(@PathVariable Long id, @RequestBody MedicineStock stockDetails) {
        try {
            MedicineStock updatedStock = service.updateStock(id, stockDetails);
            if (updatedStock != null) {
                return ResponseEntity.ok(updatedStock);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating stock: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        if (service.getStockById(id).isPresent()) {
            service.deleteStock(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

