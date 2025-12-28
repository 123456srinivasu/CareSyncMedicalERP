package com.medical.caresync.repository;

import com.medical.caresync.entities.IncomeExpenseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeExpenseReportRepository extends JpaRepository<IncomeExpenseReport, Long> {
}
