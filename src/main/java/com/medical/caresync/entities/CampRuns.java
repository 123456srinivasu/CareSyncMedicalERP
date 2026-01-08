package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "camp_runs")
public class CampRuns implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_run_id")
    private Long campRunId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id", nullable = false)
    private Camps camps;

    // As camp_location_versions schema was not provided, mapping as ID for now.
    // If table exists, update to @ManyToOne
    @Column(name = "location_version_id", nullable = false)
    private Long locationVersionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private CampPlans campPlans;

    @Column(name = "planned_date", nullable = false)
    private LocalDate plannedDate;

    @Column(name = "actual_date")
    private LocalDate actualDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CampRunStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "started_by")
    private Users startedBy;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", length = 45)
    private String createdBy;

    public enum CampRunStatus {
        PLANNED, STARTED, CLOSED, CANCELLED
    }

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

    public Long getLocationVersionId() {
        return locationVersionId;
    }

    public void setLocationVersionId(Long locationVersionId) {
        this.locationVersionId = locationVersionId;
    }

    public CampPlans getCampPlans() {
        return campPlans;
    }

    public void setCampPlans(CampPlans campPlans) {
        this.campPlans = campPlans;
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

    public Users getStartedBy() {
        return startedBy;
    }

    public void setStartedBy(Users startedBy) {
        this.startedBy = startedBy;
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
}
