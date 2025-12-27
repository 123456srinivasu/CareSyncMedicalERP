package com.medical.caresync.repository;

import com.medical.caresync.entities.BloodCamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface BloodCampRepository extends JpaRepository<BloodCamp, Integer> {
    Page<BloodCamp> findByCampId(Integer campId, Pageable pageable);
}