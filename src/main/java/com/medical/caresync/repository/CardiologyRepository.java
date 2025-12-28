package com.medical.caresync.repository;

import com.medical.caresync.entities.Cardiology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardiologyRepository extends JpaRepository<Cardiology, Long> {
}
