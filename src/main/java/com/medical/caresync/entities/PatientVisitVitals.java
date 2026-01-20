package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PATIENT_VISIT_VITALS")
public class PatientVisitVitals extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_VISIT_VITALS_ID")
    private Long id;

    @Column(name = "PATIENT_VISIT_ID")
    private Long patientVisitId;

    @Column(name = "PATIENT_ID")
    private Long patientId;

    @Column(name = "VIRAL_LOOKUP_ID")
    private Long viralLookupId;

    @Column(name = "VITAL_VALUE")
    private String vitalValue;

    @Column(name = "MEASUREMENT_TYPE")
    private String measurementType;

}
