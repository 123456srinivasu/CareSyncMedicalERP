package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientInsulin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientInsulinRepository extends JpaRepository<PatientInsulin, Long> {
}
