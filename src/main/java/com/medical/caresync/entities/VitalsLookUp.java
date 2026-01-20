package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vitals_lookup")
public class VitalsLookUp extends BaseEntity {

    @Id
    @Column(name = "VITAL_LOOKUP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vitalId;

    @Column(name = "VITAL_NAME")
    private String vitalName;

    @Column(name = "reference_range")
    private String referenceRange;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;


}
