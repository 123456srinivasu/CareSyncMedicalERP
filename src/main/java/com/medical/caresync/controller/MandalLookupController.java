package com.medical.caresync.controller;

import com.medical.caresync.entities.MandalLookup;
import com.medical.caresync.service.MandalLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mandals")
public class MandalLookupController {

    private final MandalLookupService mandalLookupService;

    @Autowired
    public MandalLookupController(MandalLookupService mandalLookupService) {
        this.mandalLookupService = mandalLookupService;
    }

    @PostMapping
    public ResponseEntity<MandalLookup> createMandal(@RequestBody MandalLookup mandalLookup) {
        MandalLookup createdMandal = mandalLookupService.createMandal(mandalLookup);
        return ResponseEntity.ok(createdMandal);
    }

    @GetMapping
    public ResponseEntity<List<MandalLookup>> getAllMandals() {
        return ResponseEntity.ok(mandalLookupService.getAllMandals());
    }

    @GetMapping("/by-district/{districtId}")
    public ResponseEntity<List<MandalLookup>> getMandalsByDistrictId(@PathVariable Long districtId) {
        return ResponseEntity.ok(mandalLookupService.getMandalsByDistrictId(districtId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MandalLookup> getMandalById(@PathVariable Long id) {
        return mandalLookupService.getMandalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MandalLookup> updateMandal(@PathVariable Long id, @RequestBody MandalLookup mandalLookup) {
        try {
            MandalLookup updatedMandal = mandalLookupService.updateMandal(id, mandalLookup);
            return ResponseEntity.ok(updatedMandal);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMandal(@PathVariable Long id) {
        mandalLookupService.deleteMandal(id);
        return ResponseEntity.noContent().build();
    }
}
