package com.medical.caresync.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_admin_settings")
public class AdminSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBL_ADMIN_SETTING_ID")
    private Long tblAdminSettingId;

    @Column(name = "SETTING_KEY", unique = true, nullable = false)
    private String settingKey;

    @Column(name = "SETTING_VALUE")
    private String settingValue;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "LABEL")
    private String label;

    public AdminSetting() {
    }

    public AdminSetting(String settingKey, String settingValue, String category, String label) {
        this.settingKey = settingKey;
        this.settingValue = settingValue;
        this.category = category;
        this.label = label;
    }

    public Long getTblAdminSettingId() {
        return tblAdminSettingId;
    }

    public void setTblAdminSettingId(Long tblAdminSettingId) {
        this.tblAdminSettingId = tblAdminSettingId;
    }

    public String getSettingKey() {
        return settingKey;
    }

    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
