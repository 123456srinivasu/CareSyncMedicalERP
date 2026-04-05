package com.medical.caresync.controller;

import com.medical.caresync.dto.WarehouseCampMedicineSentDTO;
import com.medical.caresync.service.WarehouseCampMedicineSentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse-camp-medicine-dispatches")
public class WarehouseCampMedicineSentController {

    @Autowired
    private WarehouseCampMedicineSentService sentService;

    @PostMapping("/dispatch")
    public ResponseEntity<WarehouseCampMedicineSentDTO> dispatchOrder(@RequestBody WarehouseCampMedicineSentDTO dto) {
        return ResponseEntity.ok(sentService.dispatchOrder(dto));
    }

    @GetMapping
    public ResponseEntity<List<WarehouseCampMedicineSentDTO>> getAllDispatches() {
        return ResponseEntity.ok(sentService.getAllDispatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseCampMedicineSentDTO> getDispatchById(@PathVariable Long id) {
        return ResponseEntity.ok(sentService.getDispatchById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseCampMedicineSentDTO> updateDispatch(
            @PathVariable Long id, 
            @RequestBody WarehouseCampMedicineSentDTO dto) {
        return ResponseEntity.ok(sentService.updateDispatch(id, dto));
    }
}
