package com.medical.caresync.repository;

import com.medical.caresync.entities.PaymentDetailsByPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsByPatientRepository extends JpaRepository<PaymentDetailsByPatient, Long> {
}
