package com.medical.caresync.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserRegistrationDTO {

    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Is active status is required")
    private Boolean isActive;

    @NotNull(message = "Is temporary status is required")
    private Boolean isTemporary;

    private String createdBy;

    private String updatedBy;

    @NotBlank(message = "First name is required")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private String roleName;

    private String city;

    private Integer stateLookupId;

    private Integer districtLookupId;

    private Integer mandalLookupId;

    private java.util.List<Object> userRoles;

    // Getters and Setters

    public java.util.List<Object> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(java.util.List<Object> userRoles) {
        this.userRoles = userRoles;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsTemporary() {
        return isTemporary;
    }

    public void setIsTemporary(Boolean isTemporary) {
        this.isTemporary = isTemporary;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getStateLookupId() {
        return stateLookupId;
    }

    public void setStateLookupId(Integer stateLookupId) {
        this.stateLookupId = stateLookupId;
    }

    public Integer getDistrictLookupId() {
        return districtLookupId;
    }

    public void setDistrictLookupId(Integer districtLookupId) {
        this.districtLookupId = districtLookupId;
    }

    public Integer getMandalLookupId() {
        return mandalLookupId;
    }

    public void setMandalLookupId(Integer mandalLookupId) {
        this.mandalLookupId = mandalLookupId;
    }
}
