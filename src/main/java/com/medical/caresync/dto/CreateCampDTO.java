package com.medical.caresync.dto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateCampDTO {

    private Long id;
    private LocalDate campStartDt;
    private LocalDate nextCampDate;
    private Double campPerPatientAmount;
    private String campLocation;
    private String organiserNm;
    private String organiserMobileNumber;
    private String addressLine1;
    private Long stateLookupId;
    private Long districtLookupId;
    private Long mandalLookupId;
    private String city;
    private String zipCd;
    private List<CreateCampBlockDTO> blocks = new ArrayList<>();
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
    public List<CreateCampBlockDTO> getBlocks() {
        return blocks;
    }
    public void setBlocks(List<CreateCampBlockDTO> blocks) {
        this.blocks = blocks;
    }
    public static class CreateCampBlockDTO {
        private Long id;
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
