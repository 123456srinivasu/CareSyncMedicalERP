package com.medical.caresync.repository;

import com.medical.caresync.entities.CampMedicineStockSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampMedicineStockSummaryRepository extends JpaRepository<CampMedicineStockSummary, Long> {
    
    List<CampMedicineStockSummary> findByCamps_CampId(Long campId);
    
    Optional<CampMedicineStockSummary> findByCamps_CampIdAndMedicineLookupNew_MedicationId(Long campId, Long medicationId);
}

