package com.medical.caresync.repository;

import com.medical.caresync.entities.ImagingLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagingLookupRepository extends JpaRepository<ImagingLookup, Long> {
}
