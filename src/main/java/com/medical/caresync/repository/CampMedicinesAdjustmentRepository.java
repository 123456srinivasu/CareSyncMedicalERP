package com.medical.caresync.repository;

import com.medical.caresync.entities.CampMedicinesAdjustment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampMedicinesAdjustmentRepository extends JpaRepository<CampMedicinesAdjustment, Long> {
    List<CampMedicinesAdjustment> findByCampDetailsId(Long campDetailsId);
}
