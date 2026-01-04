package com.medical.caresync.controller;

import com.medical.caresync.entities.Invoice;
import com.medical.caresync.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(service.getAllInvoices());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Invoice>> getActiveInvoices() {
        return ResponseEntity.ok(service.getActiveInvoices());
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<Invoice>> getInvoicesBySupplier(@PathVariable Long supplierId) {
        return ResponseEntity.ok(service.getInvoicesBySupplier(supplierId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        Optional<Invoice> invoice = service.getInvoiceById(id);
        return invoice.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/number/{invoiceNumber}")
    public ResponseEntity<Invoice> getInvoiceByNumber(@PathVariable String invoiceNumber) {
        Optional<Invoice> invoice = service.getInvoiceByNumber(invoiceNumber);
        return invoice.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createInvoice(@RequestBody Invoice invoice) {
        try {
            Invoice createdInvoice = service.createInvoice(invoice);
            return ResponseEntity.ok(createdInvoice);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating invoice: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInvoice(@PathVariable Long id, @RequestBody Invoice invoiceDetails) {
        try {
            Invoice updatedInvoice = service.updateInvoice(id, invoiceDetails);
            if (updatedInvoice != null) {
                return ResponseEntity.ok(updatedInvoice);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating invoice: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        if (service.getInvoiceById(id).isPresent()) {
            service.deleteInvoice(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

