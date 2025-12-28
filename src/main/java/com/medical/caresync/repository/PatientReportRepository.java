package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientReportRepository extends JpaRepository<PatientReport, Long> {
}
