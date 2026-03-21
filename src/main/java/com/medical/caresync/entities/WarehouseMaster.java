package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "warehouse_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseMaster extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Long id;

    @Column(name = "warehouse_code", nullable = false, length = 50, unique = true)
    private String warehouseCode;

    @Column(name = "warehouse_name", nullable = false, length = 150)
    private String warehouseName;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_lookup_id")
    private StateLookup state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_lookup_id")
    private DistrictLookup district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mandal_lookup_id")
    private MandalLookup mandal;

    @Column(name = "contact_person", length = 150)
    private String contactPerson;

    @Column(name = "contact_number", length = 20)
    private String contactNumber;

    @Column(name = "email_address", length = 150)
    private String emailAddress;

    @Column(name = "is_active")
    private Boolean isActive = true;
}
