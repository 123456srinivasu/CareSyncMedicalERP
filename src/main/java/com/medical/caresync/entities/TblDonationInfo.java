package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_donation_info")
public class TblDonationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "amount_donated")
    private Double amountDonated;

    @Column(name = "donation_dt")
    @Temporal(TemporalType.DATE)
    private Date donationDt;

    @ManyToOne
    @JoinColumn(name = "tbl_camp_id")
    private TblCamp tblCamp;

    @Column(name = "asset")
    private Boolean asset;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getAssetName() { return assetName; }
    public void setAssetName(String assetName) { this.assetName = assetName; }
    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }
    public Double getAmountDonated() { return amountDonated; }
    public void setAmountDonated(Double amountDonated) { this.amountDonated = amountDonated; }
    public Date getDonationDt() { return donationDt; }
    public void setDonationDt(Date donationDt) { this.donationDt = donationDt; }
    public TblCamp getTblCamp() { return tblCamp; }
    public void setTblCamp(TblCamp tblCamp) { this.tblCamp = tblCamp; }
    public Boolean getAsset() { return asset; }
    public void setAsset(Boolean asset) { this.asset = asset; }
}
