package com.medical.caresync.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CampsListDTO {

    private Long campId;
    private Long campRunId;
    private String campName;
    private String campCode;
    private String description;
    private String organizerName;
    private String organizerPhone;
    private String organizerEmail;
    private String location;
    private boolean active;
    private LocalDate plannedDate;
    private boolean isCampRunning;
    private boolean isCampReadyToStart;
    private String medicineWarehouse;
    private Long medicineWarehouseId;
    private String medicineWarehouseNameLink;
    private WarehouseMasterDTO medicineWarehouseDetails;
    private UsersResponseDTO organizerUserDetails;
    private AddressDTO locationAddress;
    private AddressDTO shippingAddress;
    private List<CampScheduleTemplateDTO> schedules;


    public CampsListDTO() {
    }

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

    public String getCampCode() {
        return campCode;
    }

    public void setCampCode(String campCode) {
        this.campCode = campCode;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerPhone() {
        return organizerPhone;
    }

    public void setOrganizerPhone(String organizerPhone) {
        this.organizerPhone = organizerPhone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate = plannedDate;
    }

    public boolean isCampRunning() {
        return isCampRunning;
    }

    public void setCampRunning(boolean campRunning) {
        isCampRunning = campRunning;
    }

    public boolean isCampReadyToStart() {
        return isCampReadyToStart;
    }

    public void setCampReadyToStart(boolean campReadyToStart) {
        isCampReadyToStart = campReadyToStart;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public Long getCampRunId() {
        return campRunId;
    }

    public void setCampRunId(Long campRunId) {
        this.campRunId = campRunId;
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

    public String getMedicineWarehouseNameLink() {
        return medicineWarehouseNameLink;
    }

    public void setMedicineWarehouseNameLink(String medicineWarehouseNameLink) {
        this.medicineWarehouseNameLink = medicineWarehouseNameLink;
    }

    public WarehouseMasterDTO getMedicineWarehouseDetails() {
        return medicineWarehouseDetails;
    }

    public void setMedicineWarehouseDetails(WarehouseMasterDTO medicineWarehouseDetails) {
        this.medicineWarehouseDetails = medicineWarehouseDetails;
    }

    public UsersResponseDTO getOrganizerUserDetails() {
        return organizerUserDetails;
    }

    public void setOrganizerUserDetails(UsersResponseDTO organizerUserDetails) {
        this.organizerUserDetails = organizerUserDetails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
