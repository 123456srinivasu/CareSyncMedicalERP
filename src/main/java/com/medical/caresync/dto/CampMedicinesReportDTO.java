package com.medical.caresync.dto;

import java.time.LocalDate;

public class CampMedicinesReportDTO {
    private Long id;
    private String medicineNm;
    private String firstNm;
    private String lastNm;
    private LocalDate campStartDt;
    private Integer morning;
    private Integer afternoon;
    private Integer night;
    private Integer quantityIssued;
    public CampMedicinesReportDTO() {
    }
    public CampMedicinesReportDTO(Long id, String medicineNm, String firstNm, String lastNm,
                                  LocalDate campStartDt, Integer morning, Integer afternoon,
                                  Integer night, Integer quantityIssued) {
        this.id = id;
        this.medicineNm = medicineNm;
        this.firstNm = firstNm;
        this.lastNm = lastNm;
        this.campStartDt = campStartDt;
        this.morning = morning;
        this.afternoon = afternoon;
        this.night = night;
        this.quantityIssued = quantityIssued;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMedicineNm() {
        return medicineNm;
    }
    public void setMedicineNm(String medicineNm) {
        this.medicineNm = medicineNm;
    }
    public String getFirstNm() {
        return firstNm;
    }
    public void setFirstNm(String firstNm) {
        this.firstNm = firstNm;
    }
    public String getLastNm() {
        return lastNm;
    }
    public void setLastNm(String lastNm) {
        this.lastNm = lastNm;
    }
    public LocalDate getCampStartDt() {
        return campStartDt;
    }
    public void setCampStartDt(LocalDate campStartDt) {
        this.campStartDt = campStartDt;
    }
    public Integer getMorning() {
        return morning;
    }
    public void setMorning(Integer morning) {
        this.morning = morning;
    }
    public Integer getAfternoon() {
        return afternoon;
    }
    public void setAfternoon(Integer afternoon) {
        this.afternoon = afternoon;
    }
    public Integer getNight() {
        return night;
    }
    public void setNight(Integer night) {
        this.night = night;
    }
    public Integer getQuantityIssued() {
        return quantityIssued;
    }
    public void setQuantityIssued(Integer quantityIssued) {
        this.quantityIssued = quantityIssued;
    }
}
