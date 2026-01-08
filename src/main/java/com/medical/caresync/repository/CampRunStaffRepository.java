package com.medical.caresync.repository;

import com.medical.caresync.entities.CampRunStaff;
import com.medical.caresync.entities.CampRunStaffId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampRunStaffRepository extends JpaRepository<CampRunStaff, CampRunStaffId> {
    List<CampRunStaff> findByCampRuns_CampRunId(Long campRunId);

    List<CampRunStaff> findByUsers_UserId(Long userId);
}
