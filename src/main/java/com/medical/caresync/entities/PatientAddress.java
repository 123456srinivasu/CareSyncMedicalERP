package com.medical.caresync.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_patient-address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientAddress extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Long addressId;

    @Column(name = "FULL_ADDRESS", nullable = false, length = 255)
    private String addressLine;


    @Column(name = "CITY", nullable = false, length = 100)
    private String city;

    @Column(name = "VILLAGE_NAME", length = 100)
    private String villageName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATE_LOOKUP_ID", nullable = false)
    private StateLookup state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISTRICT_LOOKUP_ID", nullable = false)
    private DistrictLookup district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANDAL_LOOKUP_ID", nullable = false)
    private MandalLookup mandal;

    @Column(name = "POSTAL_CODE", length = 20)
    private String postalCode;
}
