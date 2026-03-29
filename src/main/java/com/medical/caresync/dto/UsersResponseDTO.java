package com.medical.caresync.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UsersResponseDTO {

    private Long userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private boolean active;
    private List<String> roles;
    private LocalDateTime createdAt;
    private boolean temporary;
    private boolean deleted;
    private String city;
    private Integer stateLookupId;
    private Integer districtLookupId;
    private Integer mandalLookupId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isTemporary() {
        return temporary;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
