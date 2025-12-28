package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientMaternityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMaternityDetailsRepository extends JpaRepository<PatientMaternityDetails, Long> {
}
