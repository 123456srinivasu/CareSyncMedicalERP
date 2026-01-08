package com.medical.caresync.repository;

import com.medical.caresync.entities.CampRuns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampRunsRepository extends JpaRepository<CampRuns, Long> {
    List<CampRuns> findByCamps_CampId(Long campId);

    List<CampRuns> findByStatus(CampRuns.CampRunStatus status);
}
