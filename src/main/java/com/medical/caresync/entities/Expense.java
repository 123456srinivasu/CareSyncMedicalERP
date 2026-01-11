package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "expense_dt")
    @Temporal(TemporalType.DATE)
    private Date expenseDt;

    @ManyToOne
    @JoinColumn(name = "camp_id")
    private Camps tblCamp;

    @Column(name = "asset")
    private Boolean asset;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAssetName() { return assetName; }
    public void setAssetName(String assetName) { this.assetName = assetName; }
    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public Date getExpenseDt() { return expenseDt; }
    public void setExpenseDt(Date expenseDt) { this.expenseDt = expenseDt; }

    public Camps getTblCamp() {
        return tblCamp;
    }

    public void setTblCamp(Camps tblCamp) {
        this.tblCamp = tblCamp;
    }

    public Boolean getAsset() { return asset; }
    public void setAsset(Boolean asset) { this.asset = asset; }
}
