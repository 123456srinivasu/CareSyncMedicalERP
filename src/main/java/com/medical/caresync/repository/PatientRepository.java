package com.medical.caresync.repository;


import com.medical.caresync.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Default JPA methods:
    // findAll() maps to findPatients()
    // findById(Long id) maps to findPatientById(Long id)
    // deleteById(Long id) maps to deletePatientById(Long id)

    // Maintaining original method names for compatibility if needed, 
    // but typically we would use JpaRepository names directly.
    default List<Patient> findPatients() {
        return findAll();
    }

    default Patient findPatientById(Long id) {
        return findById(id).orElse(null);
    }

    default void deletePatientById(Long id) {
        deleteById(id);
    }

}
