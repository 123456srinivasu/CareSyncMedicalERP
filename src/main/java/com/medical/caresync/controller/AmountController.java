package com.medical.caresync.controller;

import com.medical.caresync.entities.Amount;
import com.medical.caresync.service.AmountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amount")
public class AmountController {

    private final AmountService amountService;

    public AmountController(AmountService amountService) {
        this.amountService = amountService;
    }

    @GetMapping
    public List<Amount> getAllAmounts() {
        return amountService.getAllAmounts();
    }

    @GetMapping("/{componentName}")
    public ResponseEntity<Amount> getAmountByComponentName(@PathVariable String componentName) {
        return amountService.getAmountByComponentName(componentName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Amount createAmount(@RequestBody Amount amount) {
        return amountService.saveAmount(amount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Amount> updateAmount(@PathVariable Long id, @RequestBody Amount amountDetails) {
        return amountService.getAmountById(id)
                .map(amount -> {
                    amount.setComponentName(amountDetails.getComponentName());
                    amount.setAmount(amountDetails.getAmount());
                    amount.setDescription(amountDetails.getDescription());
                    return ResponseEntity.ok(amountService.saveAmount(amount));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmount(@PathVariable Long id) {
        return amountService.getAmountById(id)
                .map(amount -> {
                    amountService.deleteAmount(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
