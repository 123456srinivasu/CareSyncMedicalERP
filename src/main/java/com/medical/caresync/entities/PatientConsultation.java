package com.medical.caresync.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "patient_consultation")
public class PatientConsultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_CONSULTATION_ID")
    private Long id;

    // Add fields here

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
