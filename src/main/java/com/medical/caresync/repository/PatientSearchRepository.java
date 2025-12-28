package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientSearchRepository extends JpaRepository<PatientSearch, Long> {
}
