package com.medical.caresync.repository;

import com.medical.caresync.entities.ManageLabs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageLabsRepository extends JpaRepository<ManageLabs, Long> {
}
