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
@Table(name = "patient_visit_vitals")
public class PatientVisitVitals extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_visit_vitals_id")
    private Long patientVisitVitalsId;

    @Column(name = "measurement_type")
    private String measurementType;

    @Column(name = "vital_value")
    private String vitalValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_visit_id")
    private PatientVisit patientVisit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vital_lookup_id")
    private VitalsLookUp vitalsLookUp;

}
