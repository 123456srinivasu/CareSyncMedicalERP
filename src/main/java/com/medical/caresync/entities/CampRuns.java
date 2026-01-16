package com.medical.caresync.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.medical.caresync.util.CampRunStatus;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "camp_runs")
public class CampRuns implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_run_id")
    private Long campRunId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id", nullable = false)
    private Camps camps;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "camp_address_id",
            nullable = false,
            unique = true
    )
    private CampAddress campAddress;

    @Column(name = "planned_date", nullable = false)
    private LocalDate plannedDate;

    @Column(name = "actual_date")
    private LocalDate actualDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CampRunStatus status;

    @Column(name = "started_by",  nullable = false)
    private String startedBy;

    @Column(name = "organizer_name")
    private String organizerName;

    @Column(name = "organizer_email")
    private String organizerEmail;

    @Column(name = "organizer_phone")
    private String organizerPhone;

    @OneToMany(
            mappedBy = "campRuns",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CampRunStaff> campRunUsers = new ArrayList<>();

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", length = 45)
    private String createdBy;

    @Column(name = "closed_by")
    private String closedBy;

    @Column(name = "closed_at")
    private LocalDateTime closedAt;

    @Column(name = "is_camp_ready_to_start")
    private boolean isCampReadyToStart;

    // Getters and Setters

    public Long getCampRunId() {
        return campRunId;
    }

    public void setCampRunId(Long campRunId) {
        this.campRunId = campRunId;
    }

    public Camps getCamps() {
        return camps;
    }

    public void setCamps(Camps camps) {
        this.camps = camps;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate = plannedDate;
    }

    public LocalDate getActualDate() {
        return actualDate;
    }

    public void setActualDate(LocalDate actualDate) {
        this.actualDate = actualDate;
    }

    public CampRunStatus getStatus() {
        return status;
    }

    public void setStatus(CampRunStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public CampAddress getCampAddress() {
        return campAddress;
    }

    public void setCampAddress(CampAddress campAddress) {
        this.campAddress = campAddress;
    }

    public void setStartedBy(String startedBy) {
        this.startedBy = startedBy;
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

    public List<CampRunStaff> getCampRunUsers() {
        return campRunUsers;
    }

    public void setCampRunUsers(List<CampRunStaff> campRunUsers) {
        this.campRunUsers = campRunUsers;
    }

    public String getStartedBy() {
        return startedBy;
    }

    public String getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(String closedBy) {
        this.closedBy = closedBy;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    public boolean isCampReadyToStart() {
        return isCampReadyToStart;
    }

    public void setCampReadyToStart(boolean campReadyToStart) {
        isCampReadyToStart = campReadyToStart;
    }
}
