package com.medical.caresync.repository;

import com.medical.caresync.entities.DashboardForVolunteers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardForVolunteersRepository extends JpaRepository<DashboardForVolunteers, Long> {
}
