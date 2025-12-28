package com.medical.caresync.repository;

import com.medical.caresync.entities.VeterinaryRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaryRegistrationRepository extends JpaRepository<VeterinaryRegistration, Long> {
}
