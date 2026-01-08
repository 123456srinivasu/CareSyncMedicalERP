package com.medical.caresync.controller;

import com.medical.caresync.entities.CampRuns;
import com.medical.caresync.service.CampRunsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camp-runs")
public class CampRunsController {

    private final CampRunsService service;

    @Autowired
    public CampRunsController(CampRunsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CampRuns> createRun(@RequestBody CampRuns run) {
        return ResponseEntity.ok(service.createRun(run));
    }

    @GetMapping
    public ResponseEntity<List<CampRuns>> getAllRuns() {
        return ResponseEntity.ok(service.getAllRuns());
    }

    @GetMapping("/camp/{campId}")
    public ResponseEntity<List<CampRuns>> getRunsByCampId(@PathVariable Long campId) {
        return ResponseEntity.ok(service.getRunsByCampId(campId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampRuns> getRunById(@PathVariable Long id) {
        return service.getRunById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampRuns> updateRun(@PathVariable Long id, @RequestBody CampRuns run) {
        try {
            return ResponseEntity.ok(service.updateRun(id, run));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRun(@PathVariable Long id) {
        service.deleteRun(id);
        return ResponseEntity.noContent().build();
    }
}
