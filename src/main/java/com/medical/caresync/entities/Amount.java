package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_patient_consultation")
public class Amount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TBL_PATIENT_CONSULTATION_ID")
    private Long tblAmountId;

    // This maps to the 'AMOUNT' column in your DB which stores the final calculated value
    @Column(name = "AMOUNT")
    private Double amount;

    // Persisted fields required for calculation
    @Column(name = "DUE_AMOUNT")
    private Double dueAmount;

    @Column(name = "DISCOUNT_AMOUNT")
    private Double discountAmount;

    @Column(name = "INSULIN_DISCOUNT_AMOUNT")
    private Double insulinDiscountAmount;

    @Column(name = "PAY_AT_NEXT_CAMP")
    private Double payAtNextCamp;

    @Column(name = "INSULIN_AMOUNT")
    private Double insulinAmount;

    @Column(name = "CONSULTATION_TYPE") // Used for "Free" logic (TM, TI, TB, AB, etc.)
    private String consultationType;

    // Camp fee is usually dynamic from Camp Details, but if you want it here as a simpler entity:
    @Transient
    private Double campFee = 200.00; // Default or fetched value

    public Amount() {
    }

    public Amount(Double amount, Double dueAmount, Double discountAmount) {
        this.amount = amount;
        this.dueAmount = dueAmount;
        this.discountAmount = discountAmount;
    }

    public Long getTblAmountId() {
        return tblAmountId;
    }

    public void setTblAmountId(Long tblAmountId) {
        this.tblAmountId = tblAmountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDueAmount() {
        return dueAmount != null ? dueAmount : 0.0;
    }

    public void setDueAmount(Double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount != null ? discountAmount : 0.0;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getInsulinAmount() {
        return insulinAmount != null ? insulinAmount : 0.0;
    }

    public void setInsulinAmount(Double insulinAmount) {
        this.insulinAmount = insulinAmount;
    }

    public String getConsultationType() {
        return consultationType;
    }

    public void setConsultationType(String consultationType) {
        this.consultationType = consultationType;
    }

    public Double getInsulinDiscountAmount() {
        return insulinDiscountAmount != null ? insulinDiscountAmount : 0.0;
    }

    public void setInsulinDiscountAmount(Double insulinDiscountAmount) {
        this.insulinDiscountAmount = insulinDiscountAmount;
    }

    public Double getPayAtNextCamp() {
        return payAtNextCamp != null ? payAtNextCamp : 0.0;
    }

    public void setPayAtNextCamp(Double payAtNextCamp) {
        this.payAtNextCamp = payAtNextCamp;
    }

    /**
     * Logic to recalculate the Final Amount.
     * Formula: (Camp Fee + Insulin + Due) - (Discounts + Deferrals)
     */
    public void calculateFinalAmount() {
        // 1. Check for Free Patient Types (AB = All Free, TB = Total Free, etc)
        if (consultationType != null && ("AB".equalsIgnoreCase(consultationType) || "TB".equalsIgnoreCase(consultationType))) {
            this.amount = 0.0;
            return;
        }

        // 2. Base Total (Fee + Insulin + Old Dues)
        double totalPayload = this.campFee + getInsulinAmount() + getDueAmount();

        // 3. Deductions (Discounts + Pay Later)
        double deductions = getDiscountAmount()
                + (insulinDiscountAmount != null ? insulinDiscountAmount : 0.0)
                + (payAtNextCamp != null ? payAtNextCamp : 0.0);

        // 4. Final Result
        this.amount = totalPayload - deductions;
    }
}