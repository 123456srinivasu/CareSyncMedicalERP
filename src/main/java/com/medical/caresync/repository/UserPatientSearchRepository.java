package com.medical.caresync.repository;

import com.medical.caresync.entities.UserPatientSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPatientSearchRepository extends JpaRepository<UserPatientSearch, Long> {
}
