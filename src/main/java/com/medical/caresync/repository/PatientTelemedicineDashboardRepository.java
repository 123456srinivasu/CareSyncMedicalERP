package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientTelemedicineDashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientTelemedicineDashboardRepository extends JpaRepository<PatientTelemedicineDashboard, Long> {
}
