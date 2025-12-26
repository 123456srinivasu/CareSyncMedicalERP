package com.medical.caresync.repository;

import com.medical.caresync.entities.AdminSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminSettingRepository extends JpaRepository<AdminSetting, Long> {
    
    Optional<AdminSetting> findBySettingKey(String settingKey);
    
    List<AdminSetting> findByCategory(String category);
}
