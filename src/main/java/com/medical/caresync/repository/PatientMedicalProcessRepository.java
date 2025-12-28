package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientMedicalProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMedicalProcessRepository extends JpaRepository<PatientMedicalProcess, Long> {
}
