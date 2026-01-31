package com.medical.caresync.repository;

import com.medical.caresync.entities.CampPharmacyStockTxn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CampPharmacyStockTxnRepository extends JpaRepository<CampPharmacyStockTxn, Long> {
    List<CampPharmacyStockTxn> findByPatientConsultation_PatientConsultationId(Long patientConsultationId);
}
