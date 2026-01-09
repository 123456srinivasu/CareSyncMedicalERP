package com.medical.caresync.repository;

import com.medical.caresync.entities.CampLocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampLocationsRepository extends JpaRepository<CampLocations, Long> {
    List<CampLocations> findByCamps_CampId(Long campId);
}
