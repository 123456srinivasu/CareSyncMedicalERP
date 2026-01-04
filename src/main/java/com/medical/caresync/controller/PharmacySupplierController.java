package com.medical.caresync.controller;

import com.medical.caresync.entities.PharmacySupplier;
import com.medical.caresync.service.PharmacySupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pharmacy-supplier")
public class PharmacySupplierController {

    @Autowired
    private PharmacySupplierService service;

    @GetMapping
    public ResponseEntity<List<PharmacySupplier>> getAllSuppliers() {
        return ResponseEntity.ok(service.getAllSuppliers());
    }

    @GetMapping("/active")
    public ResponseEntity<List<PharmacySupplier>> getActiveSuppliers() {
        return ResponseEntity.ok(service.getActiveSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PharmacySupplier> getSupplierById(@PathVariable Long id) {
        Optional<PharmacySupplier> supplier = service.getSupplierById(id);
        return supplier.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PharmacySupplier> createSupplier(@RequestBody PharmacySupplier supplier) {
        PharmacySupplier createdSupplier = service.createSupplier(supplier);
        return ResponseEntity.ok(createdSupplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PharmacySupplier> updateSupplier(@PathVariable Long id, @RequestBody PharmacySupplier supplierDetails) {
        PharmacySupplier updatedSupplier = service.updateSupplier(id, supplierDetails);
        if (updatedSupplier != null) {
            return ResponseEntity.ok(updatedSupplier);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        if (service.getSupplierById(id).isPresent()) {
            service.deleteSupplier(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

