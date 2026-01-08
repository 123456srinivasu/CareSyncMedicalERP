package com.medical.caresync.controller;

import com.medical.caresync.entities.CampLocations;
import com.medical.caresync.service.CampLocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camp-locations")
public class CampLocationsController {

    private final CampLocationsService service;

    @Autowired
    public CampLocationsController(CampLocationsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CampLocations> createLocation(@RequestBody CampLocations location) {
        return ResponseEntity.ok(service.createLocation(location));
    }

    @GetMapping
    public ResponseEntity<List<CampLocations>> getAllLocations() {
        return ResponseEntity.ok(service.getAllLocations());
    }

    @GetMapping("/camp/{campId}")
    public ResponseEntity<List<CampLocations>> getLocationsByCampId(@PathVariable Long campId) {
        return ResponseEntity.ok(service.getLocationsByCampId(campId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampLocations> getLocationById(@PathVariable Long id) {
        return service.getLocationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampLocations> updateLocation(@PathVariable Long id, @RequestBody CampLocations location) {
        try {
            return ResponseEntity.ok(service.updateLocation(id, location));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        service.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }
}
