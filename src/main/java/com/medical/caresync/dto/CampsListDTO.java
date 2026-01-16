package com.medical.caresync.dto;

import java.time.LocalDate;
import java.util.Date;

public class CampsListDTO {

    private Long campId;
    private String campName;
    private String campCode;
    private String organizerName;
    private String organizerPhone;
    private String organizerEmail;
    private String location;
    private boolean active;
    private LocalDate plannedDate;
    private AddressResponseDTO locationAddress;
    private AddressResponseDTO shippingAddress;
    private boolean isCampRunning;
    private boolean isCampReadyToStart;


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

    public AddressResponseDTO getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(AddressResponseDTO locationAddress) {
        this.locationAddress = locationAddress;
    }

    public AddressResponseDTO getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressResponseDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
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
}
