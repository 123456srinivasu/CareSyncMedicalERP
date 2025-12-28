package com.medical.caresync.controller;

import com.medical.caresync.dto.BloodCampResultDTO;
import com.medical.caresync.service.BloodCampResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blood-camp-results")
public class BloodCampResultController {

    @Autowired
    private BloodCampResultService service;

    @GetMapping
    public Page<BloodCampResultDTO> getAllResults(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.getAllResults(PageRequest.of(page, size));
    }

    @GetMapping("/camp/{campId}")
    public Page<BloodCampResultDTO> getResultsByCampId(
            @PathVariable Integer campId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.getResultsByCampId(campId, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodCampResultDTO> getResultById(@PathVariable Integer id) {
        BloodCampResultDTO dto = service.getResultById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public BloodCampResultDTO createResult(@RequestBody BloodCampResultDTO dto) {
        return service.saveResult(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BloodCampResultDTO> updateResult(@PathVariable Integer id, @RequestBody BloodCampResultDTO dto) {
        BloodCampResultDTO updated = service.updateResult(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
}