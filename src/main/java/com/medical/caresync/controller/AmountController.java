package com.medical.caresync.controller;

import com.medical.caresync.entities.Amount;
import com.medical.caresync.service.AmountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/amount")
public class AmountController {

    private final AmountService amountService;

    public AmountController(AmountService amountService) {
        this.amountService = amountService;
    }

    @GetMapping
    public org.springframework.data.domain.Page<Amount> getAllAmounts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return amountService.getAllAmounts(org.springframework.data.domain.PageRequest.of(page, size));
    }

    @PostMapping
    public Amount createAmount(@RequestBody Amount amount) {
        return amountService.saveAmount(amount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Amount> updateAmount(@PathVariable Long id, @RequestBody Amount amountDetails) {
        return amountService.getAmountById(id)
                .map(amount -> {
                    amount.setAmount(amountDetails.getAmount());
                    amount.setDueAmount(amountDetails.getDueAmount());
                    amount.setDiscountAmount(amountDetails.getDiscountAmount());
                    amount.setInsulinAmount(amountDetails.getInsulinAmount());
                    amount.setConsultationType(amountDetails.getConsultationType());
                    amount.setInsulinDiscountAmount(amountDetails.getInsulinDiscountAmount()); 
                    amount.setPayAtNextCamp(amountDetails.getPayAtNextCamp());

                    amount.calculateFinalAmount(); 
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
