package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientCashier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCashierRepository extends JpaRepository<PatientCashier, Long> {
}
