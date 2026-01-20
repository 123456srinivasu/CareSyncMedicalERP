package com.medical.caresync.repository;

import com.medical.caresync.entities.LabsLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabsLookupRepository extends JpaRepository<LabsLookup, Long> {
}
