package com.medical.caresync.repository;

import com.medical.caresync.entities.MasterLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterLookupRepository extends JpaRepository<MasterLookup, Long> {
}
