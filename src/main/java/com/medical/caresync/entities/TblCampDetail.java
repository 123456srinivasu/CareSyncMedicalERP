package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_camp_details")
public class TblCampDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_camp_details_id")
    private Integer tblCampDetailsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbl_camp_id")
    private TblCamp tblCamp;

    public TblCampDetail() {}

    public Integer getTblCampDetailsId() { return tblCampDetailsId; }
    public void setTblCampDetailsId(Integer tblCampDetailsId) { this.tblCampDetailsId = tblCampDetailsId; }
    public TblCamp getTblCamp() { return tblCamp; }
    public void setTblCamp(TblCamp tblCamp) { this.tblCamp = tblCamp; }
}
