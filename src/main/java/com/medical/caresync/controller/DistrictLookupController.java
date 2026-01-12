package com.medical.caresync.controller;

import com.medical.caresync.entities.DistrictLookup;
import com.medical.caresync.service.DistrictLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
public class DistrictLookupController {

    private final DistrictLookupService districtLookupService;

    @Autowired
    public DistrictLookupController(DistrictLookupService districtLookupService) {
        this.districtLookupService = districtLookupService;
    }

    @PostMapping
    public ResponseEntity<DistrictLookup> createDistrict(@RequestBody DistrictLookup districtLookup) {
        DistrictLookup createdDistrict = districtLookupService.createDistrict(districtLookup);
        return ResponseEntity.ok(createdDistrict);
    }

    @GetMapping
    public ResponseEntity<List<DistrictLookup>> getAllDistricts() {
        return ResponseEntity.ok(districtLookupService.getAllDistricts());
    }

    @GetMapping("/by-state/{stateId}")
    public ResponseEntity<List<DistrictLookup>> getDistrictsByStateId(@PathVariable Long stateId) {
        return ResponseEntity.ok(districtLookupService.getDistrictsByStateId(stateId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictLookup> getDistrictById(@PathVariable Long id) {
        return districtLookupService.getDistrictById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistrictLookup> updateDistrict(@PathVariable Long id,
            @RequestBody DistrictLookup districtLookup) {
        try {
            DistrictLookup updatedDistrict = districtLookupService.updateDistrict(id, districtLookup);
            return ResponseEntity.ok(updatedDistrict);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {
        districtLookupService.deleteDistrict(id);
        return ResponseEntity.noContent().build();
    }
}
