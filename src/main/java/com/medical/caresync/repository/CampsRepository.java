package com.medical.caresync.repository;

import com.medical.caresync.entities.Camps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampsRepository extends JpaRepository<Camps, Long> {
}

