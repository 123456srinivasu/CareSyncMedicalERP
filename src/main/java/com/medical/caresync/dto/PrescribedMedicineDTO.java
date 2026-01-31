package com.medical.caresync.dto;

import lombok.Data;

@Data
public class PrescribedMedicineDTO {
    private String medicineName;
    private String dosage; // Derived or placeholder if not in DB
    private int days; // Derived or placeholder
    private int quantity; 
}
