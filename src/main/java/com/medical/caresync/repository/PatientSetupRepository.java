package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientSetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientSetupRepository extends JpaRepository<PatientSetup, Long> {
}
