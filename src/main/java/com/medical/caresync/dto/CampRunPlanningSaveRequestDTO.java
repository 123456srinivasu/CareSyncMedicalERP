package com.medical.caresync.dto;

import java.time.LocalDate;
import java.util.List;

public class CampRunPlanningSaveRequestDTO {

    private Long campId;
    private Long campRunId;
    private LocalDate plannedDate;
    private String organizerName;
    private String organizerEmail;
    private String organizerPhone;
    private List<Long> campRunUsers;
    private boolean isCampReadyToStart;

    public Long getCampId() {
        return campId;
    }

    public void setCampId(Long campId) {
        this.campId = campId;
    }

    public Long getCampRunId() {
        return campRunId;
    }

    public void setCampRunId(Long campRunId) {
        this.campRunId = campRunId;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate = plannedDate;
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

    public List<Long> getCampRunUsers() {
        return campRunUsers;
    }

    public void setCampRunUsers(List<Long> campRunUsers) {
        this.campRunUsers = campRunUsers;
    }

    public boolean isCampReadyToStart() {
        return isCampReadyToStart;
    }

    public void setCampReadyToStart(boolean campReadyToStart) {
        isCampReadyToStart = campReadyToStart;
    }
}
