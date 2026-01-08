package com.medical.caresync.repository;

import com.medical.caresync.entities.CampPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampPlansRepository extends JpaRepository<CampPlans, Long> {
    List<CampPlans> findByCamps_CampId(Long campId);

    List<CampPlans> findByLocation_LocationId(Long locationId);
}
