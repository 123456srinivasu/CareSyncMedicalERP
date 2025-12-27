package com.medical.caresync.controller;

import com.medical.caresync.dto.BloodCampDTO;
import com.medical.caresync.service.BloodCampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/blood-camp")
public class BloodCampController {

    @Autowired
    private BloodCampService bloodCampService;

    @PostMapping("/register")
    public ResponseEntity<BloodCampDTO> register(@RequestBody BloodCampDTO dto) {
        return ResponseEntity.ok(bloodCampService.registerPatient(dto));
    }

    @GetMapping("/patients")
    public ResponseEntity<Page<BloodCampDTO>> getPatientsByCamp(
            @RequestParam Integer campId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(bloodCampService.getPatientsByCamp(campId, PageRequest.of(page, size)));
    }
}