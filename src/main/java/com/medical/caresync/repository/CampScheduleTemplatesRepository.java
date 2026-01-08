package com.medical.caresync.repository;

import com.medical.caresync.entities.CampScheduleTemplates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampScheduleTemplatesRepository extends JpaRepository<CampScheduleTemplates, Long> {
    List<CampScheduleTemplates> findByCamps_CampId(Long campId);

    List<CampScheduleTemplates> findByLocation_LocationId(Long locationId);
}
