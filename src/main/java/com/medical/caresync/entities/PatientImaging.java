package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient_imaging")
public class PatientImaging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_imaging_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_visit_id", nullable = false)
    private PatientVisit patientVisit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imaging_lookup_id", nullable = false)
    private ImagingLookup imagingLookup;

    @Column(name = "imaging_date")
    private LocalDate imagingDate;

    @Column(name = "imaging_result", columnDefinition = "TEXT")
    private String imagingResult;

}
