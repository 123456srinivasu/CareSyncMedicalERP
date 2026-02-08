package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientLabTests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientLabTestsRepository extends JpaRepository<PatientLabTests, Long> {
    List<PatientLabTests> findByPatient_TblPatientId(Long patientId);

    List<PatientLabTests> findByPatientVisit_PatientVisitId(Long patientVisitId);
}
