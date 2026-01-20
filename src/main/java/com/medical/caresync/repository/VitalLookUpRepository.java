package com.medical.caresync.repository;

import com.medical.caresync.entities.VitalsLookUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VitalLookUpRepository extends JpaRepository<VitalsLookUp, Long> {
    List<VitalsLookUp> findByIsActiveTrue();
}
