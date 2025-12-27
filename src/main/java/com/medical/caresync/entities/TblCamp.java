package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_camp")
public class TblCamp implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_camp_id")
    private Integer tblCampId;

    @Column(name = "camp_name")
    private String campName;

    public TblCamp() {}

    public Integer getTblCampId() { return tblCampId; }
    public void setTblCampId(Integer tblCampId) { this.tblCampId = tblCampId; }
    public String getCampName() { return campName; }
    public void setCampName(String campName) { this.campName = campName; }
}
