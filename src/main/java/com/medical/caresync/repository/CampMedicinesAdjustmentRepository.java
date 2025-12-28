package com.medical.caresync.repository;

import com.medical.caresync.entities.CampMedicinesAdjustment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampMedicinesAdjustmentRepository extends JpaRepository<CampMedicinesAdjustment, Long> {
}
