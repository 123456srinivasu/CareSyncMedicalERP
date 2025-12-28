package com.medical.caresync.repository;

import com.medical.caresync.entities.BloodCampResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodCampResultRepository extends JpaRepository<BloodCampResult, Integer> {
    Page<BloodCampResult> findByCampId(Integer campId, Pageable pageable);
}