package com.medical.caresync.repository;

import com.medical.caresync.entities.CampsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampsInfoRepository extends JpaRepository<CampsInfo, Long> {
}
