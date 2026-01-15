package com.medical.caresync.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "camp_users")
public class CampUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_user_id")
    private Long campUserId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_id", nullable = false)
    private Camps camps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", length = 150)
    private String createdBy;

    @Column(name = "update_at", insertable = false, updatable = false)
    private LocalDateTime updateAt;

    @Column(name = "updated_by", length = 150)
    private String updatedBy;

    // Getters and Setters

    public Long getCampUserId() {
        return campUserId;
    }

    public void setCampUserId(Long campUserId) {
        this.campUserId = campUserId;
    }

    public Camps getCamps() {
        return camps;
    }

    public void setCamps(Camps camps) {
        this.camps = camps;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isDoctor(){
        if(this.users == null)
            return false;
        Optional<UserRoles> isDoctor = this.getUsers().getUserRoles().stream()
                .filter(userRole -> "DOCTOR".equalsIgnoreCase(userRole.getRole().getRoleName()))
                .findFirst();
        return isDoctor.isPresent();
    }

    public boolean isVolunteer(){
        if(this.users == null)
            return false;
        Optional<UserRoles> isVolunteer = this.getUsers().getUserRoles().stream()
                .filter(userRole -> "VOLUNTEER".equalsIgnoreCase(userRole.getRole().getRoleName()))
                .findFirst();
        return isVolunteer.isPresent();
    }
}
