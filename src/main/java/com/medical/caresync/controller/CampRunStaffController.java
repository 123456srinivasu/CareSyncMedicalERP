package com.medical.caresync.controller;

import com.medical.caresync.entities.CampRunStaff;
import com.medical.caresync.service.CampRunStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camp-run-staff")
public class CampRunStaffController {

    private final CampRunStaffService service;

    @Autowired
    public CampRunStaffController(CampRunStaffService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CampRunStaff> assignStaff(@RequestBody CampRunStaff staff) {
        return ResponseEntity.ok(service.assignStaff(staff));
    }

    @GetMapping("/run/{runId}")
    public ResponseEntity<List<CampRunStaff>> getStaffByRunId(@PathVariable Long runId) {
        return ResponseEntity.ok(service.getStaffByRunId(runId));
    }

    @DeleteMapping("/run/{runId}/user/{userId}")
    public ResponseEntity<Void> removeStaff(@PathVariable Long runId, @PathVariable Long userId) {
        service.removeStaff(runId, userId);
        return ResponseEntity.noContent().build();
    }
}
