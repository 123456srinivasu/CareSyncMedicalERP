package com.medical.caresync.controller;

import com.medical.caresync.entities.StateLookup;
import com.medical.caresync.service.StateLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateLookupController {

    private final StateLookupService stateLookupService;

    @Autowired
    public StateLookupController(StateLookupService stateLookupService) {
        this.stateLookupService = stateLookupService;
    }

    @PostMapping
    public ResponseEntity<StateLookup> createState(@RequestBody StateLookup stateLookup) {
        StateLookup createdState = stateLookupService.createState(stateLookup);
        return ResponseEntity.ok(createdState);
    }

    @GetMapping
    public ResponseEntity<List<StateLookup>> getAllStates() {
        return ResponseEntity.ok(stateLookupService.getAllStates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateLookup> getStateById(@PathVariable Integer id) {
        return stateLookupService.getStateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StateLookup> updateState(@PathVariable Integer id, @RequestBody StateLookup stateLookup) {
        try {
            StateLookup updatedState = stateLookupService.updateState(id, stateLookup);
            return ResponseEntity.ok(updatedState);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteState(@PathVariable Integer id) {
        stateLookupService.deleteState(id);
        return ResponseEntity.noContent().build();
    }
}
