package com.medical.caresync.service;

import com.medical.caresync.entities.Invoice;
import com.medical.caresync.entities.PharmacySupplier;
import com.medical.caresync.repository.InvoiceRepository;
import com.medical.caresync.repository.PharmacySupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    @Autowired
    private PharmacySupplierRepository pharmacySupplierRepository;

    public List<Invoice> getAllInvoices() {
        return repository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        return repository.findById(id);
    }

    public Optional<Invoice> getInvoiceByNumber(String invoiceNumber) {
        return repository.findByInvoiceNumber(invoiceNumber);
    }

    @Transactional
    public Invoice createInvoice(Invoice invoice) {
        // Validate that pharmacy supplier exists
        if (invoice.getPharmacySupplier() == null || 
            invoice.getPharmacySupplier().getPharmacySupplierId() == null) {
            throw new IllegalArgumentException("Pharmacy supplier is required");
        }

        Optional<PharmacySupplier> supplier = pharmacySupplierRepository
            .findById(invoice.getPharmacySupplier().getPharmacySupplierId());
        if (supplier.isEmpty()) {
            throw new IllegalArgumentException("Pharmacy supplier not found with id: " 
                + invoice.getPharmacySupplier().getPharmacySupplierId());
        }

        // Check if invoice number already exists
        if (invoice.getInvoiceNumber() != null) {
            Optional<Invoice> existing = repository.findByInvoiceNumber(invoice.getInvoiceNumber());
            if (existing.isPresent()) {
                throw new IllegalArgumentException("Invoice number already exists: " + invoice.getInvoiceNumber());
            }
        }

        // Set defaults
        if (invoice.getIsActive() == null) {
            invoice.setIsActive(true);
        }
        if (invoice.getCreatedAt() == null) {
            invoice.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }
        if (invoice.getUpdatedAt() == null) {
            invoice.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        }

        // Set the supplier entity
        invoice.setPharmacySupplier(supplier.get());

        return repository.save(invoice);
    }

    @Transactional
    public Invoice updateInvoice(Long id, Invoice invoiceDetails) {
        Optional<Invoice> optionalInvoice = repository.findById(id);
        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();

            // Update invoice number if provided and different
            if (invoiceDetails.getInvoiceNumber() != null && 
                !invoiceDetails.getInvoiceNumber().equals(invoice.getInvoiceNumber())) {
                // Check if new number already exists
                Optional<Invoice> existing = repository.findByInvoiceNumber(invoiceDetails.getInvoiceNumber());
                if (existing.isPresent() && !existing.get().getInvoiceId().equals(id)) {
                    throw new IllegalArgumentException("Invoice number already exists: " + invoiceDetails.getInvoiceNumber());
                }
                invoice.setInvoiceNumber(invoiceDetails.getInvoiceNumber());
            }

            invoice.setInvoiceDate(invoiceDetails.getInvoiceDate());
            invoice.setAmount(invoiceDetails.getAmount());
            invoice.setPaymentMode(invoiceDetails.getPaymentMode());
            invoice.setIsActive(invoiceDetails.getIsActive());
            invoice.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            invoice.setUpdatedBy(invoiceDetails.getUpdatedBy());

            // Update pharmacy supplier if provided
            if (invoiceDetails.getPharmacySupplier() != null && 
                invoiceDetails.getPharmacySupplier().getPharmacySupplierId() != null) {
                Optional<PharmacySupplier> supplier = pharmacySupplierRepository
                    .findById(invoiceDetails.getPharmacySupplier().getPharmacySupplierId());
                if (supplier.isPresent()) {
                    invoice.setPharmacySupplier(supplier.get());
                } else {
                    throw new IllegalArgumentException("Pharmacy supplier not found with id: " 
                        + invoiceDetails.getPharmacySupplier().getPharmacySupplierId());
                }
            }

            return repository.save(invoice);
        }
        return null;
    }

    @Transactional
    public void deleteInvoice(Long id) {
        repository.deleteById(id);
    }

    public List<Invoice> getActiveInvoices() {
        return repository.findAll().stream()
                .filter(invoice -> Boolean.TRUE.equals(invoice.getIsActive()))
                .toList();
    }

    public List<Invoice> getInvoicesBySupplier(Long supplierId) {
        return repository.findAll().stream()
                .filter(invoice -> invoice.getPharmacySupplier() != null &&
                        invoice.getPharmacySupplier().getPharmacySupplierId().equals(supplierId))
                .toList();
    }
}

