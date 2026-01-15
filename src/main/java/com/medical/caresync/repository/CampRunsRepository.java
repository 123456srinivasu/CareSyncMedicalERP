package com.medical.caresync.repository;

import com.medical.caresync.entities.CampRuns;
import com.medical.caresync.util.CampRunStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampRunsRepository extends JpaRepository<CampRuns, Long> {
    List<CampRuns> findByCamps_CampId(Long campId);

    List<CampRuns> findByStatus(CampRunStatus status);


    Optional<CampRuns> findFirstByCamps_CampIdAndStatusInOrderByCreatedAtDesc(
            Long campId,
            List<CampRunStatus> statuses);
}
