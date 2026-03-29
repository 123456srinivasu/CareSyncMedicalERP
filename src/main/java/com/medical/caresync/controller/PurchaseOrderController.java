package com.medical.caresync.controller;

import com.medical.caresync.dto.PurchaseOrderDTO;
import com.medical.caresync.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrderDTO> createOrder(@RequestBody PurchaseOrderDTO orderDTO) {
        return ResponseEntity.ok(purchaseOrderService.createOrder(orderDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderDTO> updateOrder(@PathVariable Long id, @RequestBody PurchaseOrderDTO orderDTO) {
        try {
            return ResponseEntity.ok(purchaseOrderService.updateOrder(id, orderDTO));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<PurchaseOrderDTO> updateOrderNoPath(@RequestBody PurchaseOrderDTO orderDTO) {
        if (orderDTO.getPurchaseOrderId() == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            return ResponseEntity.ok(purchaseOrderService.updateOrder(orderDTO.getPurchaseOrderId(), orderDTO));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrderDTO>> getAllOrders(@RequestParam(required = false) Long warehouseId) {
        return ResponseEntity.ok(purchaseOrderService.getAllOrders(warehouseId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderDTO> getOrder(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(purchaseOrderService.getOrderById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
