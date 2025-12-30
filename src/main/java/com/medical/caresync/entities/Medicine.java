package com.medical.caresync.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_medicines_id")
    private Long id;
    @Column(name = "medicine_nm")
    private String medicineNm;
    @Column(name = "medicine_type")
    private String medicineType;
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    public Medicine() {
    }
    public Medicine(Long id, String medicineNm, String medicineType, String description, Boolean active) {
        this.id = id;
        this.medicineNm = medicineNm;
        this.medicineType = medicineType;
        this.description = description;
        this.active = active;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMedicineNm() {
        return medicineNm;
    }
    public void setMedicineNm(String medicineNm) {
        this.medicineNm = medicineNm;
    }
    public String getMedicineType() {
        return medicineType;
    }
    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
}
