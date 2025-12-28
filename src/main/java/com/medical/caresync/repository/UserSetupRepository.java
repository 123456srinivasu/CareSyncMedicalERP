package com.medical.caresync.repository;

import com.medical.caresync.entities.UserSetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSetupRepository extends JpaRepository<UserSetup, Long> {
}
