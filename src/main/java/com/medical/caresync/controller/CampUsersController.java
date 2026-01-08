package com.medical.caresync.controller;

import com.medical.caresync.entities.CampUsers;
import com.medical.caresync.service.CampUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camp-users")
public class CampUsersController {

    private final CampUsersService service;

    @Autowired
    public CampUsersController(CampUsersService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CampUsers> createCampUser(@RequestBody CampUsers campUser) {
        return ResponseEntity.ok(service.createCampUser(campUser));
    }

    @GetMapping
    public ResponseEntity<List<CampUsers>> getAllCampUsers() {
        return ResponseEntity.ok(service.getAllCampUsers());
    }

    @GetMapping("/camp/{campId}")
    public ResponseEntity<List<CampUsers>> getCampUsersByCampId(@PathVariable Long campId) {
        return ResponseEntity.ok(service.getCampUsersByCampId(campId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampUsers> getCampUserById(@PathVariable Long id) {
        return service.getCampUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampUsers> updateCampUser(@PathVariable Long id, @RequestBody CampUsers campUser) {
        try {
            return ResponseEntity.ok(service.updateCampUser(id, campUser));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampUser(@PathVariable Long id) {
        service.deleteCampUser(id);
        return ResponseEntity.noContent().build();
    }
}
