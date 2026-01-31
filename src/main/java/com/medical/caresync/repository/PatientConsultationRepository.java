package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientConsultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientConsultationRepository extends JpaRepository<PatientConsultation, Long> {
    List<PatientConsultation> findByPatient_TblPatientId(Long patientId);
}
