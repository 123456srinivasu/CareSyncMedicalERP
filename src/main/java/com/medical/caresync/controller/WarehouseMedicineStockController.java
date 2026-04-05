package com.medical.caresync.controller;

import com.medical.caresync.dto.WarehouseMedicineStockSummaryDTO;
import com.medical.caresync.service.WarehouseMedicineStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse-medicine-stock")
public class WarehouseMedicineStockController {

    @Autowired
    private WarehouseMedicineStockService stockService;

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<WarehouseMedicineStockSummaryDTO>> getStockSummary(@PathVariable Long warehouseId) {
        return ResponseEntity.ok(stockService.getStockSummaryByWarehouseId(warehouseId));
    }
}
