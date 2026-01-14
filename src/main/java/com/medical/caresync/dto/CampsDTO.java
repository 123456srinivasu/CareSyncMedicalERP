package com.medical.caresync.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CampsDTO {
    @NotNull
    private String campName;
    private String description;
    private int establishmentYear;
    private String campCode;
    @NotNull
    private String organizerName;
    @NotNull
    private String organizerEmail;
    @NotNull
    private String organizerPhone;
    private String medicineResponsibility;
    @NotNull
    private AddressDTO locationAddress;
    @NotNull
    private AddressDTO shippingAddress;
    @NotNull
    private CampScheduleTemplateDTO campScheduleTemplate;

    private List<Long> campUserIds;

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

    public String getMedicineResponsibility() {
        return medicineResponsibility;
    }

    public void setMedicineResponsibility(String medicineResponsibility) {
        this.medicineResponsibility = medicineResponsibility;
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

    public CampScheduleTemplateDTO getCampScheduleTemplate() {
        return campScheduleTemplate;
    }

    public void setCampScheduleTemplate(CampScheduleTemplateDTO campScheduleTemplate) {
        this.campScheduleTemplate = campScheduleTemplate;
    }

    public List<Long> getCampUserIds() {
        return campUserIds;
    }

    public void setCampUserIds(List<Long> campUserIds) {
        this.campUserIds = campUserIds;
    }
}
