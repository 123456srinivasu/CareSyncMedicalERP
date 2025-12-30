package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "tbl_camp_detail")
public class CampDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_camp_detail_id")
    private Long id;
    @Column(name = "camp_start_dt")
    private LocalDate campStartDt;
    @Column(name = "camp_end_dt")
    private LocalDate campEndDt;
    @Column(name = "camp_location")
    private String campLocation;
    @Column(name = "camp_name")
    private String campName;
    @Column(name = "active")
    private Boolean active;
    public CampDetail() {
    }
    public CampDetail(Long id, LocalDate campStartDt, LocalDate campEndDt, String campLocation, String campName, Boolean active) {
        this.id = id;
        this.campStartDt = campStartDt;
        this.campEndDt = campEndDt;
        this.campLocation = campLocation;
        this.campName = campName;
        this.active = active;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getCampStartDt() {
        return campStartDt;
    }
    public void setCampStartDt(LocalDate campStartDt) {
        this.campStartDt = campStartDt;
    }
    public LocalDate getCampEndDt() {
        return campEndDt;
    }
    public void setCampEndDt(LocalDate campEndDt) {
        this.campEndDt = campEndDt;
    }
    public String getCampLocation() {
        return campLocation;
    }
    public void setCampLocation(String campLocation) {
        this.campLocation = campLocation;
    }
    public String getCampName() {
        return campName;
    }
    public void setCampName(String campName) {
        this.campName = campName;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
}
