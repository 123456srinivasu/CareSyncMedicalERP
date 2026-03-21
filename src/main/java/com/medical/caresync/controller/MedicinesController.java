package com.medical.caresync.controller;

import com.medical.caresync.dto.MedicinesDTO;
import com.medical.caresync.service.MedicinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicinesController {

    private final MedicinesService medicinesService;

    @Autowired
    public MedicinesController(MedicinesService medicinesService) {
        this.medicinesService = medicinesService;
    }

    @PostMapping
    public ResponseEntity<MedicinesDTO> createMedicines(@RequestBody MedicinesDTO medicinesDTO) {
        return ResponseEntity.ok(medicinesService.createMedicines(medicinesDTO));
    }

    @GetMapping
    public ResponseEntity<List<MedicinesDTO>> getAllMedicines() {
        return ResponseEntity.ok(medicinesService.getAllMedicines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicinesDTO> getMedicinesById(@PathVariable Long id) {
        MedicinesDTO medicinesDTO = medicinesService.getMedicinesById(id);
        if (medicinesDTO != null) {
            return ResponseEntity.ok(medicinesDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicinesDTO> updateMedicines(@PathVariable Long id, @RequestBody MedicinesDTO medicinesDTO) {
        MedicinesDTO updatedMedicines = medicinesService.updateMedicines(id, medicinesDTO);
        if (updatedMedicines != null) {
            return ResponseEntity.ok(updatedMedicines);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicines(@PathVariable Long id) {
        medicinesService.deleteMedicines(id);
        return ResponseEntity.noContent().build();
    }
}
