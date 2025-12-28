package com.medical.caresync.repository;

import com.medical.caresync.entities.DiagnosisReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisReportRepository extends JpaRepository<DiagnosisReport, Long> {
}
