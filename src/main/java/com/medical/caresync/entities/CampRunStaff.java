package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "camp_run_staff",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"camp_run_id", "user_id"})
        }
)
public class CampRunStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_run_staff_id")
     private Long campRunStaffId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_run_id", nullable = false)
    private CampRuns campRuns;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @Column(name = "assigned_at", insertable = false, updatable = false)
    private LocalDateTime assignedAt;

    // Getters and Setters


    public Long getCampRunStaffId() {
        return campRunStaffId;
    }

    public void setCampRunStaffId(Long campRunStaffId) {
        this.campRunStaffId = campRunStaffId;
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
