package com.medical.caresync.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "pharmacy_supplier")
public class PharmacySupplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_supplier_id")
    private Long pharmacySupplierId;

    @Column(name = "supplier_code", length = 25)
    private String supplierCode;

    @Column(name = "supplier_name", length = 100)
    private String supplierName;

    @Column(name = "contact_name", length = 100)
    private String contactName;

    @Column(name = "contact_email", length = 100)
    private String contactEmail;

    @Column(name = "street", length = 100)
    private String street;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "pincode", length = 100)
    private String pincode;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "created_by", length = 150)
    private String createdBy;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @Column(name = "updated_by", length = 150)
    private String updatedBy;

    @OneToMany(mappedBy = "pharmacySupplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("supplier-medications")
    private List<MedicineLookupNew> medications;

    @OneToMany(mappedBy = "pharmacySupplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("supplier-invoices")
    private List<Invoice> invoices;

    public PharmacySupplier() {
    }

    public Long getPharmacySupplierId() {
        return pharmacySupplierId;
    }

    public void setPharmacySupplierId(Long pharmacySupplierId) {
        this.pharmacySupplierId = pharmacySupplierId;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
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

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<MedicineLookupNew> getMedications() {
        return medications;
    }

    public void setMedications(List<MedicineLookupNew> medications) {
        this.medications = medications;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}

