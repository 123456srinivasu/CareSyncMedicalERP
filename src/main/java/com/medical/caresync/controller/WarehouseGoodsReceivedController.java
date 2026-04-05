package com.medical.caresync.controller;

import com.medical.caresync.dto.WarehouseGoodsReceivedDTO;
import com.medical.caresync.dto.PurchaseOrderInvoicesGroupedDTO;
import com.medical.caresync.service.WarehouseGoodsReceivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse-received-invoices")
public class WarehouseGoodsReceivedController {

    @Autowired
    private WarehouseGoodsReceivedService grnService;

    @GetMapping
    public ResponseEntity<List<WarehouseGoodsReceivedDTO>> getAllGRNs() {
        return ResponseEntity.ok(grnService.getAllGRNs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseGoodsReceivedDTO> getGRNById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(grnService.getGRNById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/purchase-orders")
    public ResponseEntity<List<PurchaseOrderInvoicesGroupedDTO>> getAllInvoicesGrouped() {
        return ResponseEntity.ok(grnService.getAllGroupedByPO());
    }

    @GetMapping("/purchase-orders/{poId}")
    public ResponseEntity<PurchaseOrderInvoicesGroupedDTO> getInvoicesByPOId(@PathVariable Long poId) {
        PurchaseOrderInvoicesGroupedDTO grouped = grnService.getGroupedByPOId(poId);
        if (grouped == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grouped);
    }

    @PostMapping
    public ResponseEntity<WarehouseGoodsReceivedDTO> createGRN(@RequestBody WarehouseGoodsReceivedDTO grnDTO) {
        try {
            return new ResponseEntity<>(grnService.createGRN(grnDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseGoodsReceivedDTO> updateGRN(@PathVariable Long id, @RequestBody WarehouseGoodsReceivedDTO grnDTO) {
        try {
            return ResponseEntity.ok(grnService.updateGRN(id, grnDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<WarehouseGoodsReceivedDTO> updateGRNRoot(@RequestBody WarehouseGoodsReceivedDTO grnDTO) {
        if (grnDTO.getWarehouseGoodsReceivedId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return updateGRN(grnDTO.getWarehouseGoodsReceivedId(), grnDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGRN(@PathVariable Long id) {
        try {
            grnService.deleteGRN(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
