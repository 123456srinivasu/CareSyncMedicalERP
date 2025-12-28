package com.medical.caresync.repository;

import com.medical.caresync.entities.PrintReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintReportRepository extends JpaRepository<PrintReport, Long> {
}
