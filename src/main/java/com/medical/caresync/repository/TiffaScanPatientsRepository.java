package com.medical.caresync.repository;

import com.medical.caresync.entities.TiffaScanPatients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiffaScanPatientsRepository extends JpaRepository<TiffaScanPatients, Long> {
}
