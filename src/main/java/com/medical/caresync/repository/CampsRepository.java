package com.medical.caresync.repository;

import com.medical.caresync.entities.CampRuns;
import com.medical.caresync.entities.Camps;
import com.medical.caresync.util.CampRunStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampsRepository extends JpaRepository<Camps, Long>, JpaSpecificationExecutor<Camps> {

    @Query("""
                SELECT c
                FROM Camps c
                WHERE c.isActive = true
            """)
    List<Camps> findAllActiveCamps();

}

