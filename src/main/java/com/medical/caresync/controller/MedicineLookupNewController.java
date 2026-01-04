package com.medical.caresync.controller;

import com.medical.caresync.entities.MedicineLookupNew;
import com.medical.caresync.service.MedicineLookupNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicine-lookup")
public class MedicineLookupNewController {

    @Autowired
    private MedicineLookupNewService service;

    @GetMapping
    public ResponseEntity<List<MedicineLookupNew>> getAllMedications() {
        return ResponseEntity.ok(service.getAllMedications());
    }

    @GetMapping("/active")
    public ResponseEntity<List<MedicineLookupNew>> getActiveMedications() {
        return ResponseEntity.ok(service.getActiveMedications());
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<MedicineLookupNew>> getMedicationsBySupplier(@PathVariable Long supplierId) {
        return ResponseEntity.ok(service.getMedicationsBySupplier(supplierId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineLookupNew> getMedicationById(@PathVariable Long id) {
        Optional<MedicineLookupNew> medication = service.getMedicationById(id);
        return medication.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/code/{medicationCode}")
    public ResponseEntity<MedicineLookupNew> getMedicationByCode(@PathVariable String medicationCode) {
        Optional<MedicineLookupNew> medication = service.getMedicationByCode(medicationCode);
        return medication.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createMedication(@RequestBody MedicineLookupNew medication) {
        try {
            MedicineLookupNew createdMedication = service.createMedication(medication);
            return ResponseEntity.ok(createdMedication);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating medication: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMedication(@PathVariable Long id, @RequestBody MedicineLookupNew medicationDetails) {
        try {
            MedicineLookupNew updatedMedication = service.updateMedication(id, medicationDetails);
            if (updatedMedication != null) {
                return ResponseEntity.ok(updatedMedication);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating medication: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long id) {
        if (service.getMedicationById(id).isPresent()) {
            service.deleteMedication(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

