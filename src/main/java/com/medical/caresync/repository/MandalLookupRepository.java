package com.medical.caresync.repository;

import com.medical.caresync.entities.MandalLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MandalLookupRepository extends JpaRepository<MandalLookup, Integer> {
    List<MandalLookup> findByDistrictLookup_DistrictLookupId(Integer districtId);
}
