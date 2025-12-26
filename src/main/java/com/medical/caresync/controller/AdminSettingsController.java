package com.medical.caresync.controller;

import com.medical.caresync.entities.AdminSetting;
import com.medical.caresync.service.AdminSettingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin-settings")
public class AdminSettingsController {

    private final AdminSettingService adminSettingService;

    public AdminSettingsController(AdminSettingService adminSettingService) {
        this.adminSettingService = adminSettingService;
    }

    @GetMapping
    public List<AdminSetting> getAllSettings() {
        return adminSettingService.getAllSettings();
    }

    @GetMapping("/{key}")
    public ResponseEntity<AdminSetting> getSettingByKey(@PathVariable String key) {
        return adminSettingService.getSettingByKey(key)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public List<AdminSetting> getSettingsByCategory(@PathVariable String category) {
        return adminSettingService.getSettingsByCategory(category);
    }

    @PostMapping
    public AdminSetting saveSetting(@RequestBody AdminSetting adminSetting) {
        return adminSettingService.saveSetting(adminSetting);
    }

    @PutMapping("/{key}")
    public AdminSetting updateSetting(@PathVariable String key, @RequestBody String value) {
        return adminSettingService.updateSetting(key, value);
    }
}
