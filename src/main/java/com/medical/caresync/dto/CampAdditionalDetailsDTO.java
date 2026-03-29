package com.medical.caresync.dto;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class CampAdditionalDetailsDTO implements Serializable {

    @NotNull
    private AddressDTO locationAddress;

    @NotNull
    private AddressDTO shippingAddress;

    @NotNull
    private CampScheduleTemplateDTO campScheduleTemplate;

    private List<Long> campUserIds;

    // Getters and Setters

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
