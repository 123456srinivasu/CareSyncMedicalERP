package com.medical.caresync.repository;

import com.medical.caresync.entities.CampMedicinesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampMedicinesReportRepository extends JpaRepository<CampMedicinesReport, Long> {
}
