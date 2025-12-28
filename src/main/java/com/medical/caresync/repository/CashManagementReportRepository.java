package com.medical.caresync.repository;

import com.medical.caresync.entities.CashManagementReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashManagementReportRepository extends JpaRepository<CashManagementReport, Long> {
}
