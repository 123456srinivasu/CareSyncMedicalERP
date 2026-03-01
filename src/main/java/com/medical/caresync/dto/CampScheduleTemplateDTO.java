package com.medical.caresync.dto;

import jakarta.validation.constraints.NotNull;

public class CampScheduleTemplateDTO {

    @NotNull
    private String dayOfWeek; // MONDAY, ...
    @NotNull
    private Integer weekOfMonth; // 1–5
    private Boolean monthJanuary = false;
    private Boolean monthFebruary = false;
    private Boolean monthMarch = false;
    private Boolean monthApril = false;
    private Boolean monthMay = false;
    private Boolean monthJune = false;
    private Boolean monthJuly = false;
    private Boolean monthAugust = false;
    private Boolean monthSeptember = false;
    private Boolean monthOctober = false;
    private Boolean monthNovember = false;
    private Boolean monthDecember = false;

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
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
}
