package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientCampEdit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCampEditRepository extends JpaRepository<PatientCampEdit, Long> {
}
