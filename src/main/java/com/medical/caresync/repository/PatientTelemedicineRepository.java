package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientTelemedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientTelemedicineRepository extends JpaRepository<PatientTelemedicine, Long> {
}
