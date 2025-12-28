package com.medical.caresync.repository;

import com.medical.caresync.entities.UserDashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDashboardRepository extends JpaRepository<UserDashboard, Long> {
}
