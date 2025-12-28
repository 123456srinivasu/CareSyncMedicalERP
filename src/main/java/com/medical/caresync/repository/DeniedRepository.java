package com.medical.caresync.repository;

import com.medical.caresync.entities.Denied;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeniedRepository extends JpaRepository<Denied, Long> {
}
