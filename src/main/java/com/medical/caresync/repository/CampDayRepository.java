package com.medical.caresync.repository;

import com.medical.caresync.entities.CampDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampDayRepository extends JpaRepository<CampDay, Long> {
}
