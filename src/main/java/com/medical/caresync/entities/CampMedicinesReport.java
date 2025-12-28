package com.medical.caresync.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "camp_medicines_report")
public class CampMedicinesReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
