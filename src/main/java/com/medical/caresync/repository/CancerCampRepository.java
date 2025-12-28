package com.medical.caresync.repository;

import com.medical.caresync.entities.CancerCamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancerCampRepository extends JpaRepository<CancerCamp, Long> {
}
