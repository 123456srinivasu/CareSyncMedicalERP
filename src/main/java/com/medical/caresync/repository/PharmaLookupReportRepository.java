package com.medical.caresync.repository;

import com.medical.caresync.entities.PharmaLookupReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmaLookupReportRepository extends JpaRepository<PharmaLookupReport, Long> {
}
