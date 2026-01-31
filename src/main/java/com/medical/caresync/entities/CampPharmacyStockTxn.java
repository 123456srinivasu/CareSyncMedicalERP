package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "camp_pharmacy_stock_txn")
public class CampPharmacyStockTxn implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_pharmacy_stock_txn_id")
    private Long campPharmacyStockTxnId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id", nullable = false)
    private MedicineLookupNew medicine;

    @Column(name = "camp_id", nullable = false)
    private Long campId;

    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_run_id")
    private CampRuns campRuns;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_consulation_id")
    private PatientConsultation patientConsultation;

    @Column(name = "txn_type", length = 45, nullable = false)
    private String txnType;

    @Column(name = "qunatity_change")
    private Integer quantityChange;

    @Column(name = "remarks", length = 200)
    private String remarks;

    @Column(name = "created_at")
    private Timestamp createdAt;

    public Long getCampPharmacyStockTxnId() { return campPharmacyStockTxnId; }
    public void setCampPharmacyStockTxnId(Long campPharmacyStockTxnId) { this.campPharmacyStockTxnId = campPharmacyStockTxnId; }

    public MedicineLookupNew getMedicine() { return medicine; }
    public void setMedicine(MedicineLookupNew medicine) { this.medicine = medicine; }

    public Long getCampId() { return campId; }
    public void setCampId(Long campId) { this.campId = campId; }

    public Long getLocationId() { return locationId; }
    public void setLocationId(Long locationId) { this.locationId = locationId; }

    public CampRuns getCampRuns() { return campRuns; }
    public void setCampRuns(CampRuns campRuns) { this.campRuns = campRuns; }

    public PatientConsultation getPatientConsultation() { return patientConsultation; }
    public void setPatientConsultation(PatientConsultation patientConsultation) { this.patientConsultation = patientConsultation; }

    public String getTxnType() { return txnType; }
    public void setTxnType(String txnType) { this.txnType = txnType; }

    public Integer getQuantityChange() { return quantityChange; }
    public void setQuantityChange(Integer quantityChange) { this.quantityChange = quantityChange; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
