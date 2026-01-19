package com.medical.caresync.dto;

import java.util.List;

public class CampPurchaseOrderRequestDTO {

    private Long campId;
    private String requestedBy;
    private String remarks;
    private List<SupplierOrderDTO> supplierOrders;

    public CampPurchaseOrderRequestDTO() {
    }

    public Long getCampId() {
        return campId;
    }

    public void setCampId(Long campId) {
        this.campId = campId;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<SupplierOrderDTO> getSupplierOrders() {
        return supplierOrders;
    }

    public void setSupplierOrders(List<SupplierOrderDTO> supplierOrders) {
        this.supplierOrders = supplierOrders;
    }

    public static class SupplierOrderDTO {
        private Long supplierId;
        private List<MedicineOrderDTO> medicines;

        public SupplierOrderDTO() {
        }

        public Long getSupplierId() {
            return supplierId;
        }

        public void setSupplierId(Long supplierId) {
            this.supplierId = supplierId;
        }

        public List<MedicineOrderDTO> getMedicines() {
            return medicines;
        }

        public void setMedicines(List<MedicineOrderDTO> medicines) {
            this.medicines = medicines;
        }
    }

    public static class MedicineOrderDTO {
        private Long medicationId;
        private Integer requestedQuantity;

        public MedicineOrderDTO() {
        }

        public Long getMedicationId() {
            return medicationId;
        }

        public void setMedicationId(Long medicationId) {
            this.medicationId = medicationId;
        }

        public Integer getRequestedQuantity() {
            return requestedQuantity;
        }

        public void setRequestedQuantity(Integer requestedQuantity) {
            this.requestedQuantity = requestedQuantity;
        }
    }
}
