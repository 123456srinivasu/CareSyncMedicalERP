package com.medical.caresync.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "medicine_stock",
       uniqueConstraints = @UniqueConstraint(name = "uq_batch_medicine_invoice", 
                                            columnNames = {"batch_number", "medication_id", "invoice_id"}))
public class MedicineStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_stock_id")
    private Long medicineStockId;

    @Column(name = "batch_number", length = 50, nullable = false)
    private String batchNumber;

    @Column(name = "hsn_code", length = 50, nullable = false)
    private String hsnCode;

    @Column(name = "manufacturing_date", nullable = false)
    private Date manufacturingDate;

    @Column(name = "expiry_date", nullable = false)
    private Date expiryDate;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_stock_medication"))
    @JsonBackReference("medication-stocks")
    private MedicineLookupNew medication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_stock_invoice"))
    @JsonBackReference("invoice-stocks")
    private Invoice invoice;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_stock_camp"))
    private Camps camp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_medicine_stock_summary_id")
    @JsonBackReference("summary-stocks")
    private CampMedicineStockSummary campMedicineStockSummary;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "created_by", length = 150)
    private String createdBy;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "updated_by", length = 150)
    private String updatedBy;

    public MedicineStock() {
    }

    public Long getMedicineStockId() {
        return medicineStockId;
    }

    public void setMedicineStockId(Long medicineStockId) {
        this.medicineStockId = medicineStockId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MedicineLookupNew getMedication() {
        return medication;
    }

    public void setMedication(MedicineLookupNew medication) {
        this.medication = medication;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Camps getCamp() {
        return camp;
    }

    public void setCamp(Camps camp) {
        this.camp = camp;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public CampMedicineStockSummary getCampMedicineStockSummary() {
        return campMedicineStockSummary;
    }

    public void setCampMedicineStockSummary(CampMedicineStockSummary campMedicineStockSummary) {
        this.campMedicineStockSummary = campMedicineStockSummary;
    }
}

