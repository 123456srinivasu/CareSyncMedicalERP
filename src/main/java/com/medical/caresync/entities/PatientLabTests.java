package com.medical.caresync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient_lab_tests")
public class PatientLabTests extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_lab_test_id")
    private Long patientLabTestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbl_patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_visit_id", nullable = false)
    private PatientVisit patientVisit;

    @Column(name = "lab_test_lookup_id")
    private Long labTestLookupId;

    @Column(name = "lab_test_date")
    private LocalDate labTestDate;

    @Column(name = "test_with_medicine_s")
    private String testWithMedicineS;

    @Column(name = "test_result_value")
    private String testResultValue;

    @Column(name = "test_result_unit")
    private String testResultUnit;

    @Column(name = "reference_value")
    private String referenceValue;

    @Column(name = "remark")
    private String remark;

}
