package com.medical.caresync.repository;

import com.medical.caresync.entities.PharmaLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmaLookupRepository extends JpaRepository<PharmaLookup, Long> {
}
