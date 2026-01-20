package com.medical.caresync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabsLookupDTO {
    private Long id;
    private String labTestName;
    private String description;
    private Boolean isActive;

}
