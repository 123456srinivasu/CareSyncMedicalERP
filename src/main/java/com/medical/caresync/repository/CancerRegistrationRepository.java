package com.medical.caresync.repository;

import com.medical.caresync.entities.CancerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancerRegistrationRepository extends JpaRepository<CancerRegistration, Long> {
}
