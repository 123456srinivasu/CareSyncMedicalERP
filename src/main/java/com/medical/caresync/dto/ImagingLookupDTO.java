package com.medical.caresync.dto;

public class ImagingLookupDTO {
    private Long id;
    private String imagingName;
    private String description;
    private Boolean isActive;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getImagingName() { return imagingName; }
    public void setImagingName(String imagingName) { this.imagingName = imagingName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}
