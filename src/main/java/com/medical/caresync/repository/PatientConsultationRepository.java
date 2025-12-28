package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientConsultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientConsultationRepository extends JpaRepository<PatientConsultation, Long> {
}
