package com.medical.caresync.controller;

import com.medical.caresync.entities.Camps;
import com.medical.caresync.service.CampsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/camps")
public class CampsController {

    @Autowired
    private CampsService service;

    @GetMapping
    public ResponseEntity<List<Camps>> getAllCamps() {
        return ResponseEntity.ok(service.getAllCamps());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Camps>> getActiveCamps() {
        return ResponseEntity.ok(service.getActiveCamps());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camps> getCampById(@PathVariable Long id) {
        Optional<Camps> camp = service.getCampById(id);
        return camp.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Camps> createCamp(@RequestBody Camps camp) {
        Camps createdCamp = service.createCamp(camp);
        return ResponseEntity.ok(createdCamp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camps> updateCamp(@PathVariable Long id, @RequestBody Camps campDetails) {
        Camps updatedCamp = service.updateCamp(id, campDetails);
        if (updatedCamp != null) {
            return ResponseEntity.ok(updatedCamp);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCamp(@PathVariable Long id) {
        if (service.getCampById(id).isPresent()) {
            service.deleteCamp(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

