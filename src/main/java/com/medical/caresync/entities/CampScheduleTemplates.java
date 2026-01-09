package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "camp_schedule_templates")
public class CampScheduleTemplates implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "template_id")
    private Long templateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id", nullable = false)
    private Camps camps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private CampLocations location;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeekEnum dayOfWeek;

    @Column(name = "week_of_month", nullable = false)
    private Integer weekOfMonth;

    @Column(name = "month_january")
    private Boolean monthJanuary = false;

    @Column(name = "month_february")
    private Boolean monthFebruary = false;

    @Column(name = "month_march")
    private Boolean monthMarch = false;

    @Column(name = "month_april")
    private Boolean monthApril = false;

    @Column(name = "month_may")
    private Boolean monthMay = false;

    @Column(name = "month_june")
    private Boolean monthJune = false;

    @Column(name = "month_july")
    private Boolean monthJuly = false;

    @Column(name = "month_august")
    private Boolean monthAugust = false;

    @Column(name = "month_september")
    private Boolean monthSeptember = false;

    @Column(name = "month_october")
    private Boolean monthOctober = false;

    @Column(name = "month_november")
    private Boolean monthNovember = false;

    @Column(name = "month_december")
    private Boolean monthDecember = false;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", length = 45)
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by", length = 45)
    private String updatedBy;

    public enum DayOfWeekEnum {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    // Getters and Setters

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Camps getCamps() {
        return camps;
    }

    public void setCamps(Camps camps) {
        this.camps = camps;
    }

    public CampLocations getLocation() {
        return location;
    }

    public void setLocation(CampLocations location) {
        this.location = location;
    }

    public DayOfWeekEnum getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeekEnum dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getWeekOfMonth() {
        return weekOfMonth;
    }

    public void setWeekOfMonth(Integer weekOfMonth) {
        this.weekOfMonth = weekOfMonth;
    }

    public Boolean getMonthJanuary() {
        return monthJanuary;
    }

    public void setMonthJanuary(Boolean monthJanuary) {
        this.monthJanuary = monthJanuary;
    }

    public Boolean getMonthFebruary() {
        return monthFebruary;
    }

    public void setMonthFebruary(Boolean monthFebruary) {
        this.monthFebruary = monthFebruary;
    }

    public Boolean getMonthMarch() {
        return monthMarch;
    }

    public void setMonthMarch(Boolean monthMarch) {
        this.monthMarch = monthMarch;
    }

    public Boolean getMonthApril() {
        return monthApril;
    }

    public void setMonthApril(Boolean monthApril) {
        this.monthApril = monthApril;
    }

    public Boolean getMonthMay() {
        return monthMay;
    }

    public void setMonthMay(Boolean monthMay) {
        this.monthMay = monthMay;
    }

    public Boolean getMonthJune() {
        return monthJune;
    }

    public void setMonthJune(Boolean monthJune) {
        this.monthJune = monthJune;
    }

    public Boolean getMonthJuly() {
        return monthJuly;
    }

    public void setMonthJuly(Boolean monthJuly) {
        this.monthJuly = monthJuly;
    }

    public Boolean getMonthAugust() {
        return monthAugust;
    }

    public void setMonthAugust(Boolean monthAugust) {
        this.monthAugust = monthAugust;
    }

    public Boolean getMonthSeptember() {
        return monthSeptember;
    }

    public void setMonthSeptember(Boolean monthSeptember) {
        this.monthSeptember = monthSeptember;
    }

    public Boolean getMonthOctober() {
        return monthOctober;
    }

    public void setMonthOctober(Boolean monthOctober) {
        this.monthOctober = monthOctober;
    }

    public Boolean getMonthNovember() {
        return monthNovember;
    }

    public void setMonthNovember(Boolean monthNovember) {
        this.monthNovember = monthNovember;
    }

    public Boolean getMonthDecember() {
        return monthDecember;
    }

    public void setMonthDecember(Boolean monthDecember) {
        this.monthDecember = monthDecember;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
