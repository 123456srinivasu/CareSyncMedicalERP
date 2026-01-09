package com.medical.caresync.controller;

import com.medical.caresync.entities.CampPlans;
import com.medical.caresync.service.CampPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camp-plans")
public class CampPlansController {

    private final CampPlansService service;

    @Autowired
    public CampPlansController(CampPlansService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CampPlans> createPlan(@RequestBody CampPlans plan) {
        return ResponseEntity.ok(service.createPlan(plan));
    }

    @GetMapping
    public ResponseEntity<List<CampPlans>> getAllPlans() {
        return ResponseEntity.ok(service.getAllPlans());
    }

    @GetMapping("/camp/{campId}")
    public ResponseEntity<List<CampPlans>> getPlansByCampId(@PathVariable Long campId) {
        return ResponseEntity.ok(service.getPlansByCampId(campId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampPlans> getPlanById(@PathVariable Long id) {
        return service.getPlanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampPlans> updatePlan(@PathVariable Long id, @RequestBody CampPlans plan) {
        try {
            return ResponseEntity.ok(service.updatePlan(id, plan));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        service.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
