package com.medical.caresync.repository;

import com.medical.caresync.entities.AdminSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminSettingsRepository extends JpaRepository<AdminSettings, Long> {
}
