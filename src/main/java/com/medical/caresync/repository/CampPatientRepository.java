package com.medical.caresync.repository;

import com.medical.caresync.entities.CampPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CampPatientRepository extends JpaRepository<CampPatient, Long> {
    @Query("SELECT p FROM CampPatient p WHERE " +
           "(p.mrNumber LIKE %:query% OR " +
           "p.firstName LIKE %:query% OR " +
           "p.lastName LIKE %:query% OR " +
           "p.oldMrNumber LIKE %:query% OR " +
           "p.newMrNumber LIKE %:query%)")
    List<CampPatient> searchPatients(@Param("query") String query);
}
