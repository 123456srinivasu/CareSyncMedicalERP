package com.medical.caresync.dto;

import com.medical.caresync.entities.CampMedicineStockSummary;
import com.medical.caresync.util.CampRunStatus;

import java.time.LocalDate;
import java.util.List;

public class CampRunPlanningViewDTO {

    private Long campRunId;
    private Long campId;
    private String organizerName;
    private String organizerPhone;
    private String organizerEmail;
    private List<UsersResponseDTO> campRunUsers;
    private List<CampMedicineStockSummary> campMedicineStockSummaries;
    private LocalDate plannedDate;
    private LocalDate actualStartDate;
    private CampRunStatus campRunStatus;

    public Long getCampRunId() {
        return campRunId;
    }

    public void setCampRunId(Long campRunId) {
        this.campRunId = campRunId;
    }

    public Long getCampId() {
        return campId;
    }

    public void setCampId(Long campId) {
        this.campId = campId;
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

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public List<UsersResponseDTO> getCampRunUsers() {
        return campRunUsers;
    }

    public void setCampRunUsers(List<UsersResponseDTO> campRunUsers) {
        this.campRunUsers = campRunUsers;
    }

    public List<CampMedicineStockSummary> getCampMedicineStockSummaries() {
        return campMedicineStockSummaries;
    }

    public void setCampMedicineStockSummaries(List<CampMedicineStockSummary> campMedicineStockSummaries) {
        this.campMedicineStockSummaries = campMedicineStockSummaries;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate = plannedDate;
    }

    public LocalDate getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(LocalDate actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public CampRunStatus getCampRunStatus() {
        return campRunStatus;
    }

    public void setCampRunStatus(CampRunStatus campRunStatus) {
        this.campRunStatus = campRunStatus;
    }
}
