package com.medical.caresync.repository;

import com.medical.caresync.entities.ExpensesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesReportRepository extends JpaRepository<ExpensesReport, Long> {
}
