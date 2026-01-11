package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mandal_lookup")
public class MandalLookup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANDAL_LOOKUP_ID")
    private Long mandalLookupId;

    @Column(name = "MANDAL_NAME", nullable = false, length = 30)
    private String mandalName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DISTRICT_LOOKUP_ID", nullable = false)
    private DistrictLookup districtLookup;

    public MandalLookup() {
    }

    public MandalLookup(Long mandalLookupId) {
        this.mandalLookupId = mandalLookupId;
    }


    public Long getMandalLookupId() {
        return mandalLookupId;
    }

    public void setMandalLookupId(Long mandalLookupId) {
        this.mandalLookupId = mandalLookupId;
    }

    public String getMandalName() {
        return mandalName;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
    }

    public DistrictLookup getDistrictLookup() {
        return districtLookup;
    }

    public void setDistrictLookup(DistrictLookup districtLookup) {
        this.districtLookup = districtLookup;
    }
}
