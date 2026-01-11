package com.medical.caresync.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "camps")
public class Camps implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_id")
    private Long campId;

    @Column(name = "camp_name", length = 100, nullable = false)
    private String campName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by", length = 150)
    private String createdBy;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @Column(name = "updated_by", length = 150)
    private String updatedBy;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "camp_establishment_year", length = 4)
    private int campEstablishmentYear;

    @Column(name = "CAMP_CODE", length = 10)
    private String campCode;

    @Column(name = "organizer_name")
    private String organizerName;

    @Column(name = "organizer_email")
    private String organizerEmail;

    @Column(name = "organizer_phone")
    private String organizerPhone;

    @Column(name = "medicine_responsibility")
    private String medicineResponsibility;

    @OneToMany(mappedBy = "camps", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("camp-summaries")
    @JsonIgnore
    private List<CampMedicineStockSummary> campMedicineStockSummaries;

    @OneToMany(
            mappedBy = "camp",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<CampAddress> campAddresses;

    @OneToMany(mappedBy = "camps", fetch = FetchType.LAZY)
    private List<CampScheduleTemplates> schedules;

    public Camps() {
    }

    public Long getCampId() {
        return campId;
    }

    public void setCampId(Long campId) {
        this.campId = campId;
    }

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getCampEstablishmentYear() {
        return campEstablishmentYear;
    }

    public void setCampEstablishmentYear(int campEstablishmentYear) {
        this.campEstablishmentYear = campEstablishmentYear;
    }

    public String getCampCode() {
        return campCode;
    }

    public void setCampCode(String campCode) {
        this.campCode = campCode;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public String getOrganizerPhone() {
        return organizerPhone;
    }

    public void setOrganizerPhone(String organizerPhone) {
        this.organizerPhone = organizerPhone;
    }

    public String getMedicineResponsibility() {
        return medicineResponsibility;
    }

    public void setMedicineResponsibility(String medicineResponsibility) {
        this.medicineResponsibility = medicineResponsibility;
    }

    public List<CampMedicineStockSummary> getCampMedicineStockSummaries() {
        return campMedicineStockSummaries;
    }

    public void setCampMedicineStockSummaries(List<CampMedicineStockSummary> campMedicineStockSummaries) {
        this.campMedicineStockSummaries = campMedicineStockSummaries;
    }

    public List<CampAddress> getCampAddresses() {
        return campAddresses;
    }

    public void setCampAddresses(List<CampAddress> campAddresses) {
        this.campAddresses = campAddresses;
    }

    public List<CampScheduleTemplates> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<CampScheduleTemplates> schedules) {
        this.schedules = schedules;
    }
}

