package com.medical.caresync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.caresync.dto.CreateCampDTO;
import com.medical.caresync.service.CreateCampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/create-camp")
public class CreateCampController {

   @Autowired
    private CreateCampService service;
    @PostMapping
    public ResponseEntity<CreateCampDTO> createCamp(@RequestBody CreateCampDTO dto) {
        CreateCampDTO createdCamp = service.createCamp(dto);
        return ResponseEntity.ok(createdCamp);
    }
    @GetMapping
    public ResponseEntity<List<CreateCampDTO>> getAllCamps() {
        return ResponseEntity.ok(service.getAllCamps());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CreateCampDTO> getCampById(@PathVariable Long id) {
        CreateCampDTO camp = service.getCampById(id);
        if (camp != null) {
            return ResponseEntity.ok(camp);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CreateCampDTO> updateCamp(@PathVariable Long id, @RequestBody CreateCampDTO dto) {
        CreateCampDTO updatedCamp = service.updateCamp(id, dto);
        if (updatedCamp != null) {
            return ResponseEntity.ok(updatedCamp);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCamp(@PathVariable Long id) {
        service.deleteCamp(id);
        return ResponseEntity.noContent().build();
    }
}