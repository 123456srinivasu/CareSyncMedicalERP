package com.medical.caresync.repository;

import com.medical.caresync.entities.DonationsReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationsReportRepository extends JpaRepository<DonationsReport, Long> {
}
