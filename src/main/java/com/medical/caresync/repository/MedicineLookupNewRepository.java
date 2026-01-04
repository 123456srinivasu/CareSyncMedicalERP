package com.medical.caresync.repository;

import com.medical.caresync.entities.MedicineLookupNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicineLookupNewRepository extends JpaRepository<MedicineLookupNew, Long> {
    
    Optional<MedicineLookupNew> findByMedicationCode(String medicationCode);
}

