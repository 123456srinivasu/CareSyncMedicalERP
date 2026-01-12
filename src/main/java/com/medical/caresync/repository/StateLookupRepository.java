package com.medical.caresync.repository;

import com.medical.caresync.entities.StateLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateLookupRepository extends JpaRepository<StateLookup, Integer> {
}
