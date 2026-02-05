package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vitals_lookup")
public class VitalsLookUp extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vital_lookup_id")
    private Long vitalLookupId;

    @Column(name = "vital_name")
    private String vitalName;

    @Column(name = "reference_range", length = 50)
    private String referenceRange;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

}
