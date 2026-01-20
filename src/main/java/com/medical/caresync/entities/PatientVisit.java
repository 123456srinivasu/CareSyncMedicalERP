package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "PATIENT_VISIT")
@NoArgsConstructor
@AllArgsConstructor
public class PatientVisit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_visit_id")
    private Long patientVisitId;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @Column(name = "visit_type")
    private String visitType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TBL_PATIENT_ID", nullable = false)
    private Patient patient;

    @Column(name = "medicine_pickid")
    private Long medicinePickId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_run_id")
    private CampRuns campRuns;


}
