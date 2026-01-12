package com.medical.caresync.repository;

import com.medical.caresync.entities.DistrictLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictLookupRepository extends JpaRepository<DistrictLookup, Long> {
    List<DistrictLookup> findByStateLookup_StateLookupId(Long stateId);
}
