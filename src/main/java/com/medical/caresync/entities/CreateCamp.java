package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "create_camp")
public class CreateCamp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "camp_start_dt")
    private LocalDate campStartDt;
    @Column(name = "next_camp_date")
    private LocalDate nextCampDate;
    @Column(name = "camp_per_patient_amount")
    private Double campPerPatientAmount;
    @Column(name = "camp_location")
    private String campLocation;
    @Column(name = "organiser_nm")
    private String organiserNm;
    @Column(name = "organiser_mobile_number")
    private String organiserMobileNumber;
    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name = "state_lookup_id")
    private Long stateLookupId;
    @Column(name = "district_lookup_id")
    private Long districtLookupId;
    @Column(name = "mandal_lookup_id")
    private Long mandalLookupId;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_cd")
    private String zipCd;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "create_camp_id")
    private List<CreateCampBlock> blocks = new ArrayList<>();
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getCampStartDt() {
        return campStartDt;
    }
    public void setCampStartDt(LocalDate campStartDt) {
        this.campStartDt = campStartDt;
    }
    public LocalDate getNextCampDate() {
        return nextCampDate;
    }
    public void setNextCampDate(LocalDate nextCampDate) {
        this.nextCampDate = nextCampDate;
    }
    public Double getCampPerPatientAmount() {
        return campPerPatientAmount;
    }
    public void setCampPerPatientAmount(Double campPerPatientAmount) {
        this.campPerPatientAmount = campPerPatientAmount;
    }
    public String getCampLocation() {
        return campLocation;
    }
    public void setCampLocation(String campLocation) {
        this.campLocation = campLocation;
    }
    public String getOrganiserNm() {
        return organiserNm;
    }
    public void setOrganiserNm(String organiserNm) {
        this.organiserNm = organiserNm;
    }
    public String getOrganiserMobileNumber() {
        return organiserMobileNumber;
    }
    public void setOrganiserMobileNumber(String organiserMobileNumber) {
        this.organiserMobileNumber = organiserMobileNumber;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public Long getStateLookupId() {
        return stateLookupId;
    }
    public void setStateLookupId(Long stateLookupId) {
        this.stateLookupId = stateLookupId;
    }
    public Long getDistrictLookupId() {
        return districtLookupId;
    }
    public void setDistrictLookupId(Long districtLookupId) {
        this.districtLookupId = districtLookupId;
    }
    public Long getMandalLookupId() {
        return mandalLookupId;
    }
    public void setMandalLookupId(Long mandalLookupId) {
        this.mandalLookupId = mandalLookupId;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZipCd() {
        return zipCd;
    }
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }
    public List<CreateCampBlock> getBlocks() {
        return blocks;
    }
    public void setBlocks(List<CreateCampBlock> blocks) {
        this.blocks = blocks;
    }

    @Entity
    @Table(name = "create_camp_block")
    public static class CreateCampBlock {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "block_name")
        private String blockName;
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getBlockName() {
            return blockName;
        }
        public void setBlockName(String blockName) {
            this.blockName = blockName;
        }
    }
}
