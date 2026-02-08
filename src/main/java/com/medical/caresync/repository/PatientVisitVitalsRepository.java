package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientVisitVitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientVisitVitalsRepository extends JpaRepository<PatientVisitVitals, Long> {
    List<PatientVisitVitals> findByPatient_TblPatientId(Long patientId);

    List<PatientVisitVitals> findByPatientVisit_PatientVisitId(Long patientVisitId);
}
