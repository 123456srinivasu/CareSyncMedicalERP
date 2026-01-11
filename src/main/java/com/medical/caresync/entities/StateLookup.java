package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "state_lookup")
public class StateLookup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATE_LOOKUP_ID")
    private Long stateLookupId;

    @Column(name = "STATE_NAME", nullable = false, length = 30)
    private String stateName;

    @Column(name = "STATE_CD", nullable = false, length = 2)
    private String stateCd;

    @OneToMany(mappedBy = "stateLookup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DistrictLookup> districts;

    public StateLookup() {
    }

    public StateLookup(Long stateLookupId) {
        this.stateLookupId = stateLookupId;
    }

    public Long getStateLookupId() {
        return stateLookupId;
    }

    public void setStateLookupId(Long stateLookupId) {
        this.stateLookupId = stateLookupId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCd() {
        return stateCd;
    }

    public void setStateCd(String stateCd) {
        this.stateCd = stateCd;
    }

    public List<DistrictLookup> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictLookup> districts) {
        this.districts = districts;
    }
}
