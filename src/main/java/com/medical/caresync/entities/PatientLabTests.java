package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PATIENT_LAB_TESTS")
public class PatientLabTests extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_LAB_TEST_ID")
    private Long patientLabTestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TBL_PATIENT_ID", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_visit_id", nullable = false)
    private PatientVisit patientVisit;

    @Column(name = "LAB_TEST_LOOKUP_ID")
    private Long labTestLookupId;

    @Column(name = "LAB_TEST_DATE")
    private LocalDate labTestDate;

    @Column(name = "TEST_WITH_MEDICINE_S")
    private String testWithMedicineS;

}
