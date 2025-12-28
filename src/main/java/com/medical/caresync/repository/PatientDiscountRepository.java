package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDiscountRepository extends JpaRepository<PatientDiscount, Long> {
}
