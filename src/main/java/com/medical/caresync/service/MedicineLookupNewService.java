package com.medical.caresync.service;

import com.medical.caresync.entities.MedicineLookupNew;
import com.medical.caresync.entities.PharmacySupplier;
import com.medical.caresync.repository.MedicineLookupNewRepository;
import com.medical.caresync.repository.PharmacySupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MedicineLookupNewService {

    @Autowired
    private MedicineLookupNewRepository repository;

    @Autowired
    private PharmacySupplierRepository pharmacySupplierRepository;

    public List<MedicineLookupNew> getAllMedications() {
        return repository.findAll();
    }

    public Optional<MedicineLookupNew> getMedicationById(Long id) {
        return repository.findById(id);
    }

    public Optional<MedicineLookupNew> getMedicationByCode(String medicationCode) {
        return repository.findByMedicationCode(medicationCode);
    }

    @Transactional
    public MedicineLookupNew createMedication(MedicineLookupNew medication) {
        // Validate that pharmacy supplier exists
        if (medication.getPharmacySupplier() == null || 
            medication.getPharmacySupplier().getPharmacySupplierId() == null) {
            throw new IllegalArgumentException("Pharmacy supplier is required");
        }

        Optional<PharmacySupplier> supplier = pharmacySupplierRepository
            .findById(medication.getPharmacySupplier().getPharmacySupplierId());
        if (supplier.isEmpty()) {
            throw new IllegalArgumentException("Pharmacy supplier not found with id: " 
                + medication.getPharmacySupplier().getPharmacySupplierId());
        }

        // Check if medication code already exists
        if (medication.getMedicationCode() != null) {
            Optional<MedicineLookupNew> existing = repository.findByMedicationCode(medication.getMedicationCode());
            if (existing.isPresent()) {
                throw new IllegalArgumentException("Medication code already exists: " + medication.getMedicationCode());
            }
        }

        // Set defaults
        if (medication.getIsActive() == null) {
            medication.setIsActive(true);
        }
        if (medication.getCreatedAt() == null) {
            medication.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }
        if (medication.getUpdatedAt() == null) {
            medication.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        }

        // Set the supplier entity
        medication.setPharmacySupplier(supplier.get());

        return repository.save(medication);
    }

    @Transactional
    public MedicineLookupNew updateMedication(Long id, MedicineLookupNew medicationDetails) {
        Optional<MedicineLookupNew> optionalMedication = repository.findById(id);
        if (optionalMedication.isPresent()) {
            MedicineLookupNew medication = optionalMedication.get();

            // Update medication code if provided and different
            if (medicationDetails.getMedicationCode() != null && 
                !medicationDetails.getMedicationCode().equals(medication.getMedicationCode())) {
                // Check if new code already exists
                Optional<MedicineLookupNew> existing = repository.findByMedicationCode(medicationDetails.getMedicationCode());
                if (existing.isPresent() && !existing.get().getMedicationId().equals(id)) {
                    throw new IllegalArgumentException("Medication code already exists: " + medicationDetails.getMedicationCode());
                }
                medication.setMedicationCode(medicationDetails.getMedicationCode());
            }

            medication.setMedicationName(medicationDetails.getMedicationName());
            medication.setMedicineType(medicationDetails.getMedicineType());
            medication.setIsActive(medicationDetails.getIsActive());
            medication.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            medication.setUpdatedBy(medicationDetails.getUpdatedBy());

            // Update pharmacy supplier if provided
            if (medicationDetails.getPharmacySupplier() != null && 
                medicationDetails.getPharmacySupplier().getPharmacySupplierId() != null) {
                Optional<PharmacySupplier> supplier = pharmacySupplierRepository
                    .findById(medicationDetails.getPharmacySupplier().getPharmacySupplierId());
                if (supplier.isPresent()) {
                    medication.setPharmacySupplier(supplier.get());
                } else {
                    throw new IllegalArgumentException("Pharmacy supplier not found with id: " 
                        + medicationDetails.getPharmacySupplier().getPharmacySupplierId());
                }
            }

            return repository.save(medication);
        }
        return null;
    }

    @Transactional
    public void deleteMedication(Long id) {
        repository.deleteById(id);
    }

    public List<MedicineLookupNew> getActiveMedications() {
        return repository.findAll().stream()
                .filter(medication -> Boolean.TRUE.equals(medication.getIsActive()))
                .toList();
    }

    public List<MedicineLookupNew> getMedicationsBySupplier(Long supplierId) {
        return repository.findAll().stream()
                .filter(medication -> medication.getPharmacySupplier() != null &&
                        medication.getPharmacySupplier().getPharmacySupplierId().equals(supplierId))
                .toList();
    }
}

