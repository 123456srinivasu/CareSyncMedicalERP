package com.medical.caresync.repository;

import com.medical.caresync.entities.CampData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampDataRepository extends JpaRepository<CampData, Long> {
}
