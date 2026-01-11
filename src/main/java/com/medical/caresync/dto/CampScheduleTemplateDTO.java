package com.medical.caresync.dto;

import jakarta.validation.constraints.NotNull;

public class CampScheduleTemplateDTO {

    @NotNull
    private String dayOfWeek; // MONDAY, ...
    @NotNull
    private Integer weekOfMonth; // 1–5
    private Boolean january = false;
    private Boolean february = false;
    private Boolean march = false;
    private Boolean april = false;
    private Boolean may = false;
    private Boolean june = false;
    private Boolean july = false;
    private Boolean august = false;
    private Boolean september = false;
    private Boolean october = false;
    private Boolean november = false;
    private Boolean december = false;

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

    public Boolean getJanuary() {
        return january;
    }

    public void setJanuary(Boolean january) {
        this.january = january;
    }

    public Boolean getFebruary() {
        return february;
    }

    public void setFebruary(Boolean february) {
        this.february = february;
    }

    public Boolean getMarch() {
        return march;
    }

    public void setMarch(Boolean march) {
        this.march = march;
    }

    public Boolean getApril() {
        return april;
    }

    public void setApril(Boolean april) {
        this.april = april;
    }

    public Boolean getMay() {
        return may;
    }

    public void setMay(Boolean may) {
        this.may = may;
    }

    public Boolean getJune() {
        return june;
    }

    public void setJune(Boolean june) {
        this.june = june;
    }

    public Boolean getJuly() {
        return july;
    }

    public void setJuly(Boolean july) {
        this.july = july;
    }

    public Boolean getAugust() {
        return august;
    }

    public void setAugust(Boolean august) {
        this.august = august;
    }

    public Boolean getSeptember() {
        return september;
    }

    public void setSeptember(Boolean september) {
        this.september = september;
    }

    public Boolean getOctober() {
        return october;
    }

    public void setOctober(Boolean october) {
        this.october = october;
    }

    public Boolean getNovember() {
        return november;
    }

    public void setNovember(Boolean november) {
        this.november = november;
    }

    public Boolean getDecember() {
        return december;
    }

    public void setDecember(Boolean december) {
        this.december = december;
    }
}
