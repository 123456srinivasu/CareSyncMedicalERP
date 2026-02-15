package com.medical.caresync.dto;

public class CampMedicineStockSummaryResponseDTO {

    private Long campMedicineStockSummaryId;
    private Long campId;
    private Long medicationId;
    private String medicationName;
    private String medicationCode;
    private String medicineType;
    private Integer quantity;

    public CampMedicineStockSummaryResponseDTO() {
    }

    public CampMedicineStockSummaryResponseDTO(Long campMedicineStockSummaryId, Long campId, Long medicationId, 
                                               String medicationName, String medicationCode, String medicineType, 
                                               Integer quantity) {
        this.campMedicineStockSummaryId = campMedicineStockSummaryId;
        this.campId = campId;
        this.medicationId = medicationId;
        this.medicationName = medicationName;
        this.medicationCode = medicationCode;
        this.medicineType = medicineType;
        this.quantity = quantity;
    }

    public Long getCampMedicineStockSummaryId() {
        return campMedicineStockSummaryId;
    }

    public void setCampMedicineStockSummaryId(Long campMedicineStockSummaryId) {
        this.campMedicineStockSummaryId = campMedicineStockSummaryId;
    }

    public Long getCampId() {
        return campId;
    }

    public void setCampId(Long campId) {
        this.campId = campId;
    }

    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedicationCode() {
        return medicationCode;
    }

    public void setMedicationCode(String medicationCode) {
        this.medicationCode = medicationCode;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
