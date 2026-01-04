package com.medical.caresync.repository;

import com.medical.caresync.entities.MedicineStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineStockRepository extends JpaRepository<MedicineStock, Long> {
    
    List<MedicineStock> findByMedication_MedicationId(Long medicationId);
    
    List<MedicineStock> findByInvoice_InvoiceId(Long invoiceId);
    
    List<MedicineStock> findByCamp_CampId(Long campId);
    
    Optional<MedicineStock> findByBatchNumberAndMedication_MedicationIdAndInvoice_InvoiceId(
        String batchNumber, Long medicationId, Long invoiceId);
}

