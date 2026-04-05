package com.medical.caresync.controller;

import com.medical.caresync.dto.WarehouseCampMedicineOrderDTO;
import com.medical.caresync.service.WarehouseCampMedicineOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse-camp-medicine-orders")
public class WarehouseCampMedicineOrderController {

    @Autowired
    private WarehouseCampMedicineOrderService orderService;

    @PostMapping
    public ResponseEntity<WarehouseCampMedicineOrderDTO> createOrder(@RequestBody WarehouseCampMedicineOrderDTO dto) {
        return ResponseEntity.ok(orderService.createOrder(dto));
    }

    @GetMapping
    public ResponseEntity<List<WarehouseCampMedicineOrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseCampMedicineOrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseCampMedicineOrderDTO> updateOrder(
            @PathVariable Long id, 
            @RequestBody WarehouseCampMedicineOrderDTO dto) {
        return ResponseEntity.ok(orderService.updateOrder(id, dto));
    }
}
