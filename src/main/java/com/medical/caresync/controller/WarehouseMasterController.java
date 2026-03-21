package com.medical.caresync.controller;

import com.medical.caresync.dto.WarehouseMasterDTO;
import com.medical.caresync.service.WarehouseMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse-master")
public class WarehouseMasterController {

    private final WarehouseMasterService service;

    @Autowired
    public WarehouseMasterController(WarehouseMasterService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WarehouseMasterDTO> createWarehouse(@RequestBody WarehouseMasterDTO dto) {
        return ResponseEntity.ok(service.createWarehouse(dto));
    }

    @GetMapping
    public ResponseEntity<List<WarehouseMasterDTO>> getAllWarehouses() {
        return ResponseEntity.ok(service.getAllWarehouses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseMasterDTO> getWarehouseById(@PathVariable Long id) {
        WarehouseMasterDTO dto = service.getWarehouseById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseMasterDTO> updateWarehouse(@PathVariable Long id, @RequestBody WarehouseMasterDTO dto) {
        WarehouseMasterDTO updated = service.updateWarehouse(id, dto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        service.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }
}
