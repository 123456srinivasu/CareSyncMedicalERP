package com.medical.caresync.repository;

import com.medical.caresync.entities.CreateCamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateCampRepository extends JpaRepository<CreateCamp, Long> {
}
