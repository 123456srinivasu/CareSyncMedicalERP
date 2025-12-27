package com.medical.caresync.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_camp")
public class TblCamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_camp_id")
    private Integer tblCampId;

    @Column(name = "camp_name")
    private String campName;

    // Getters and Setters
    public Integer getTblCampId() { return tblCampId; }
    public void setTblCampId(Integer tblCampId) { this.tblCampId = tblCampId; }
    public String getCampName() { return campName; }
    public void setCampName(String campName) { this.campName = campName; }
}
