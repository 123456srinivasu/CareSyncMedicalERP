package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientAddressRepository extends JpaRepository<PatientAddress, Long> {
}
