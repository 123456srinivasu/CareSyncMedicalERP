package com.medical.caresync.service;

import com.medical.caresync.entities.AdminSetting;
import com.medical.caresync.repository.AdminSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminSettingService {

    private final AdminSettingRepository adminSettingRepository;

    @Autowired
    public AdminSettingService(AdminSettingRepository adminSettingRepository) {
        this.adminSettingRepository = adminSettingRepository;
    }

    public List<AdminSetting> getAllSettings() {
        return adminSettingRepository.findAll();
    }

    public Optional<AdminSetting> getSettingByKey(String key) {
        return adminSettingRepository.findBySettingKey(key);
    }

    public List<AdminSetting> getSettingsByCategory(String category) {
        return adminSettingRepository.findByCategory(category);
    }

    public AdminSetting updateSetting(String key, String value) {
        Optional<AdminSetting> existing = adminSettingRepository.findBySettingKey(key);
        if (existing.isPresent()) {
            AdminSetting setting = existing.get();
            setting.setSettingValue(value);
            return adminSettingRepository.save(setting);
        } else {
            AdminSetting newSetting = new AdminSetting();
            newSetting.setSettingKey(key);
            newSetting.setSettingValue(value);
            return adminSettingRepository.save(newSetting);
        }
    }

    public AdminSetting saveSetting(AdminSetting adminSetting) {
        return adminSettingRepository.save(adminSetting);
    }
}
