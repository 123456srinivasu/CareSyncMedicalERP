package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientCamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCampRepository extends JpaRepository<PatientCamp, Long> {
}
