package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "camp_run_staff")
public class CampRunStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CampRunStaffId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("campRunId")
    @JoinColumn(name = "camp_run_id")
    private CampRuns campRuns;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name = "assigned_at", insertable = false, updatable = false)
    private LocalDateTime assignedAt;

    // Getters and Setters

    public CampRunStaffId getId() {
        return id;
    }

    public void setId(CampRunStaffId id) {
        this.id = id;
    }

    public CampRuns getCampRuns() {
        return campRuns;
    }

    public void setCampRuns(CampRuns campRuns) {
        this.campRuns = campRuns;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }
}
