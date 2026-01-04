package com.medical.caresync.service;

import com.medical.caresync.entities.PharmacySupplier;
import com.medical.caresync.repository.PharmacySupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PharmacySupplierService {

    @Autowired
    private PharmacySupplierRepository repository;

    public List<PharmacySupplier> getAllSuppliers() {
        return repository.findAll();
    }

    public Optional<PharmacySupplier> getSupplierById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public PharmacySupplier createSupplier(PharmacySupplier supplier) {
        if (supplier.getIsActive() == null) {
            supplier.setIsActive(true);
        }
        if (supplier.getCreatedAt() == null) {
            supplier.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }
        if (supplier.getUpdateAt() == null) {
            supplier.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        }
        return repository.save(supplier);
    }

    @Transactional
    public PharmacySupplier updateSupplier(Long id, PharmacySupplier supplierDetails) {
        Optional<PharmacySupplier> optionalSupplier = repository.findById(id);
        if (optionalSupplier.isPresent()) {
            PharmacySupplier supplier = optionalSupplier.get();
            supplier.setSupplierCode(supplierDetails.getSupplierCode());
            supplier.setSupplierName(supplierDetails.getSupplierName());
            supplier.setContactName(supplierDetails.getContactName());
            supplier.setContactEmail(supplierDetails.getContactEmail());
            supplier.setStreet(supplierDetails.getStreet());
            supplier.setCity(supplierDetails.getCity());
            supplier.setState(supplierDetails.getState());
            supplier.setPincode(supplierDetails.getPincode());
            supplier.setIsActive(supplierDetails.getIsActive());
            supplier.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            supplier.setUpdatedBy(supplierDetails.getUpdatedBy());
            return repository.save(supplier);
        }
        return null;
    }

    @Transactional
    public void deleteSupplier(Long id) {
        repository.deleteById(id);
    }

    public List<PharmacySupplier> getActiveSuppliers() {
        return repository.findAll().stream()
                .filter(supplier -> Boolean.TRUE.equals(supplier.getIsActive()))
                .toList();
    }
}

