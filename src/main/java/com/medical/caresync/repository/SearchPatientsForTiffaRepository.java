package com.medical.caresync.repository;

import com.medical.caresync.entities.SearchPatientsForTiffa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchPatientsForTiffaRepository extends JpaRepository<SearchPatientsForTiffa, Long> {
}
