package com.medical.caresync.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "camp_medicine_stock_summary")
public class CampMedicineStockSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_medicine_stock_summary_id")
    private Long campMedicineStockSummaryId;

    @Column(name = "quantity")
    private Integer quantity;

    // Many-to-One: Many summaries can belong to one medicine
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id", referencedColumnName = "medication_id")
    private MedicineLookupNew medicineLookupNew;

    // Many-to-One: Many summaries can belong to one camp
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id", referencedColumnName = "camp_id")
    @JsonBackReference("camp-summaries")
    private Camps camps;

    // One-to-Many: One summary can have many medicine stocks
    @OneToMany(mappedBy = "campMedicineStockSummary", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonManagedReference("summary-stocks")
    private List<MedicineStock> medicineStocks = new ArrayList<>();

    public CampMedicineStockSummary() {
    }

    public Long getCampMedicineStockSummaryId() {
        return campMedicineStockSummaryId;
    }

    public void setCampMedicineStockSummaryId(Long campMedicineStockSummaryId) {
        this.campMedicineStockSummaryId = campMedicineStockSummaryId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MedicineLookupNew getMedicineLookupNew() {
        return medicineLookupNew;
    }

    public void setMedicineLookupNew(MedicineLookupNew medicineLookupNew) {
        this.medicineLookupNew = medicineLookupNew;
    }

    public Camps getCamps() {
        return camps;
    }

    public void setCamps(Camps camps) {
        this.camps = camps;
    }

    public List<MedicineStock> getMedicineStocks() {
        return medicineStocks;
    }

    public void setMedicineStocks(List<MedicineStock> medicineStocks) {
        this.medicineStocks = medicineStocks;
    }

    // Helper methods for bidirectional relationship
    public void addMedicineStock(MedicineStock medicineStock) {
        medicineStocks.add(medicineStock);
        medicineStock.setCampMedicineStockSummary(this);
    }

    public void removeMedicineStock(MedicineStock medicineStock) {
        medicineStocks.remove(medicineStock);
        medicineStock.setCampMedicineStockSummary(null);
    }
}

