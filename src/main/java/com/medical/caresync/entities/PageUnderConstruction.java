package com.medical.caresync.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "page_under_construction")
public class PageUnderConstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add fields here

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
