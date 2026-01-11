package com.medical.caresync.repository;

import com.medical.caresync.entities.Camps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampsRepository extends JpaRepository<Camps, Long> {

    @Query("""
                SELECT c
                FROM Camps c
                WHERE c.isActive = true
            """)
    List<Camps> findAllActiveCamps();
}

