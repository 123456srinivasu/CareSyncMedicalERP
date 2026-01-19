package com.medical.caresync.repository;

import com.medical.caresync.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRegistrationRepository extends JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {

    @Modifying
    @Query("UPDATE Patient p SET p.active = false WHERE p.tblPatientId = :id AND p.active = true")
    void softDeleteById(@Param("id") Long id);
}
