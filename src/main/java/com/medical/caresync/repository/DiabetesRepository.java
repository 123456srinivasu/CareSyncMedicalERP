package com.medical.caresync.repository;

import com.medical.caresync.entities.Diabetes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiabetesRepository extends JpaRepository<Diabetes, Long> {
}
