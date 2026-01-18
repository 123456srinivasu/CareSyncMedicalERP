package com.medical.caresync.controller;

import com.medical.caresync.dto.CampPurchaseOrderRequestDTO;
import com.medical.caresync.dto.CampPurchaseOrderResponseDTO;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.service.CampPurchaseOrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/camp-purchase-orders")
public class CampPurchaseOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampPurchaseOrderController.class);

    @Autowired
    private CampPurchaseOrderService campPurchaseOrderService;

    @PostMapping
    public ResponseEntity<?> createPurchaseOrders(@Valid @RequestBody CampPurchaseOrderRequestDTO requestDTO) {
        try {
            List<Long> createdOrderIds = campPurchaseOrderService.createPurchaseOrders(requestDTO);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Purchase orders created successfully");
            response.put("purchaseOrderIds", createdOrderIds);
            response.put("count", createdOrderIds.size());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (BadRequestException ex) {
            LOGGER.error("Invalid request while creating purchase orders", ex);
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        } catch (Exception e) {
            LOGGER.error("Exception while creating purchase orders", e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePurchaseOrder(
            @PathVariable Long id,
            @Valid @RequestBody CampPurchaseOrderRequestDTO requestDTO) {
        try {
            CampPurchaseOrderResponseDTO updatedOrder = campPurchaseOrderService.updatePurchaseOrder(id, requestDTO);
            return ResponseEntity.ok(updatedOrder);
        } catch (BadRequestException ex) {
            LOGGER.error("Invalid request while updating purchase order", ex);
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        } catch (Exception e) {
            LOGGER.error("Exception while updating purchase order", e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseOrderById(@PathVariable Long id) {
        try {
            CampPurchaseOrderResponseDTO purchaseOrder = campPurchaseOrderService.getPurchaseOrderById(id);
            return ResponseEntity.ok(purchaseOrder);
        } catch (BadRequestException ex) {
            LOGGER.error("Purchase order not found", ex);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
        } catch (Exception e) {
            LOGGER.error("Exception while fetching purchase order", e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchaseOrders(
            @RequestParam(required = false) Long campId,
            @RequestParam(required = false) Long supplierId) {
        try {
            List<CampPurchaseOrderResponseDTO> purchaseOrders;

            if (campId != null) {
                purchaseOrders = campPurchaseOrderService.getPurchaseOrdersByCampId(campId);
            } else if (supplierId != null) {
                purchaseOrders = campPurchaseOrderService.getPurchaseOrdersBySupplierId(supplierId);
            } else {
                purchaseOrders = campPurchaseOrderService.getAllPurchaseOrders();
            }

            return ResponseEntity.ok(purchaseOrders);
        } catch (Exception e) {
            LOGGER.error("Exception while fetching purchase orders", e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchaseOrder(@PathVariable Long id) {
        try {
            campPurchaseOrderService.deletePurchaseOrder(id);
            return ResponseEntity.noContent().build();
        } catch (BadRequestException ex) {
            LOGGER.error("Purchase order not found", ex);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
        } catch (Exception e) {
            LOGGER.error("Exception while deleting purchase order", e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Internal server error"));
        }
    }
}
