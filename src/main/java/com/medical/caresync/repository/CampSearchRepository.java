package com.medical.caresync.repository;

import com.medical.caresync.entities.CampSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampSearchRepository extends JpaRepository<CampSearch, Long> {
}
