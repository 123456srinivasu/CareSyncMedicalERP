package com.medical.caresync.repository;

import com.medical.caresync.entities.CampPatients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampPatientsRepository extends JpaRepository<CampPatients, Long> {
}
