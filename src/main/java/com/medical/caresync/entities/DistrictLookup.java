package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "district_lookup")
public class DistrictLookup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISTRICT_LOOKUP_ID")
    private Integer districtLookupId;

    @Column(name = "DISTRICT_NAME", nullable = false, length = 30)
    private String districtName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STATE_LOOKUP_ID", nullable = false)
    private StateLookup stateLookup;

    @OneToMany(mappedBy = "districtLookup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MandalLookup> mandals;

    // Getters and Setters

    public Integer getDistrictLookupId() {
        return districtLookupId;
    }

    public void setDistrictLookupId(Integer districtLookupId) {
        this.districtLookupId = districtLookupId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public StateLookup getStateLookup() {
        return stateLookup;
    }

    public void setStateLookup(StateLookup stateLookup) {
        this.stateLookup = stateLookup;
    }

    public List<MandalLookup> getMandals() {
        return mandals;
    }

    public void setMandals(List<MandalLookup> mandals) {
        this.mandals = mandals;
    }
}
