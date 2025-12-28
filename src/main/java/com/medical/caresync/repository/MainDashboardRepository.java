package com.medical.caresync.repository;

import com.medical.caresync.entities.MainDashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainDashboardRepository extends JpaRepository<MainDashboard, Long> {
}
