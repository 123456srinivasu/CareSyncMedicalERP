package com.medical.caresync.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_amount")
public class Amount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBL_AMOUNT_ID")
    private Long tblAmountId;

    @Column(name = "COMPONENT_NAME", unique = true, nullable = false)
    private String componentName;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DESCRIPTION")
    private String description;

    public Amount() {
    }

    public Amount(String componentName, Double amount, String description) {
        this.componentName = componentName;
        this.amount = amount;
        this.description = description;
    }

    public Long getTblAmountId() {
        return tblAmountId;
    }

    public void setTblAmountId(Long tblAmountId) {
        this.tblAmountId = tblAmountId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
