package com.medical.caresync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CampRunStaffId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "camp_run_id")
    private Long campRunId;

    @Column(name = "user_id")
    private Long userId;

    public CampRunStaffId() {
    }

    public CampRunStaffId(Long campRunId, Long userId) {
        this.campRunId = campRunId;
        this.userId = userId;
    }

    public Long getCampRunId() {
        return campRunId;
    }

    public void setCampRunId(Long campRunId) {
        this.campRunId = campRunId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CampRunStaffId that = (CampRunStaffId) o;
        return Objects.equals(campRunId, that.campRunId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campRunId, userId);
    }
}
