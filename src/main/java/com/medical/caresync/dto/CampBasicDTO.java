package com.medical.caresync.dto;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class CampBasicDTO implements Serializable {

    private Long campId;

    @NotNull
    private String campName;

    private String description;

    private int establishmentYear;

    private String campCode;

    private Long organizerUserId;

    private String organizerName;

    private String organizerEmail;

    private String organizerPhone;

    private String medicineWarehouse;

    private Long medicineWarehouseId;

    private WarehouseMasterDTO medicineWarehouseDetails;

    private Boolean active;

    @jakarta.validation.Valid
    private AddressDTO locationAddress;
    @jakarta.validation.Valid
    private AddressDTO shippingAddress;

    private UsersResponseDTO organizerUserDetails;

    @jakarta.validation.Valid
    private List<CampScheduleTemplateDTO> schedules;

    // Getters and Setters

    public Long getCampId() {
        return campId;
    }

    public void setCampId(Long campId) {
        this.campId = campId;
    }

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public String getCampCode() {
        return campCode;
    }

    public void setCampCode(String campCode) {
        this.campCode = campCode;
    }

    public Long getOrganizerUserId() {
        return organizerUserId;
    }

    public void setOrganizerUserId(Long organizerUserId) {
        this.organizerUserId = organizerUserId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public String getOrganizerPhone() {
        return organizerPhone;
    }

    public void setOrganizerPhone(String organizerPhone) {
        this.organizerPhone = organizerPhone;
    }

    public String getMedicineWarehouse() {
        return medicineWarehouse;
    }

    public void setMedicineWarehouse(String medicineWarehouse) {
        this.medicineWarehouse = medicineWarehouse;
    }

    public Long getMedicineWarehouseId() {
        return medicineWarehouseId;
    }

    public void setMedicineWarehouseId(Long medicineWarehouseId) {
        this.medicineWarehouseId = medicineWarehouseId;
    }

    public WarehouseMasterDTO getMedicineWarehouseDetails() {
        return medicineWarehouseDetails;
    }

    public void setMedicineWarehouseDetails(WarehouseMasterDTO medicineWarehouseDetails) {
        this.medicineWarehouseDetails = medicineWarehouseDetails;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UsersResponseDTO getOrganizerUserDetails() {
        return organizerUserDetails;
    }

    public void setOrganizerUserDetails(UsersResponseDTO organizerUserDetails) {
        this.organizerUserDetails = organizerUserDetails;
    }

    public AddressDTO getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(AddressDTO locationAddress) {
        this.locationAddress = locationAddress;
    }

    public AddressDTO getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<CampScheduleTemplateDTO> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<CampScheduleTemplateDTO> schedules) {
        this.schedules = schedules;
    }
}
