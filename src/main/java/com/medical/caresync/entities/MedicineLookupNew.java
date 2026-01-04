package com.medical.caresync.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "medicine_lookup_new", 
       uniqueConstraints = @UniqueConstraint(name = "uq_medication_code", columnNames = "medication_code"))
public class MedicineLookupNew implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medication_id")
    private Long medicationId;

    @Column(name = "medication_code", length = 50, nullable = false, unique = true)
    private String medicationCode;

    @Column(name = "medication_name", length = 150, nullable = false)
    private String medicationName;

    @Column(name = "medicine_type", length = 50, nullable = false)
    private String medicineType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacy_supplier_id", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_medicine_lookup_supplier"))
    @JsonBackReference("supplier-medications")
    private PharmacySupplier pharmacySupplier;

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

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("medication-stocks")
    private List<MedicineStock> medicineStocks;

    public MedicineLookupNew() {
    }

    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    public String getMedicationCode() {
        return medicationCode;
    }

    public void setMedicationCode(String medicationCode) {
        this.medicationCode = medicationCode;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public PharmacySupplier getPharmacySupplier() {
        return pharmacySupplier;
    }

    public void setPharmacySupplier(PharmacySupplier pharmacySupplier) {
        this.pharmacySupplier = pharmacySupplier;
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

    public List<MedicineStock> getMedicineStocks() {
        return medicineStocks;
    }

    public void setMedicineStocks(List<MedicineStock> medicineStocks) {
        this.medicineStocks = medicineStocks;
    }
}

