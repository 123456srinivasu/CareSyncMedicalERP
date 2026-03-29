package com.medical.caresync.service;

import com.medical.caresync.dto.MedicinesDTO;
import com.medical.caresync.entities.Medicines;
import com.medical.caresync.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicinesService {

    @Autowired
    private MedicinesRepository medicinesRepository;

    public List<MedicinesDTO> getAllMedicines() {
        return medicinesRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public MedicinesDTO getMedicinesById(Long id) {
        return medicinesRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public MedicinesDTO createMedicines(MedicinesDTO medicinesDTO) {
        Medicines medicines = convertToEntity(medicinesDTO);
        medicines = medicinesRepository.save(medicines);
        return convertToDTO(medicines);
    }

    public MedicinesDTO updateMedicines(Long id, MedicinesDTO medicinesDTO) {
        if (medicinesRepository.existsById(id)) {
            Medicines medicines = convertToEntity(medicinesDTO);
            medicines.setId(id);
            medicines = medicinesRepository.save(medicines);
            return convertToDTO(medicines);
        }
        return null;
    }

    public void deleteMedicines(Long id) {
        medicinesRepository.deleteById(id);
    }

    private MedicinesDTO convertToDTO(Medicines medicines) {
        if (medicines == null) return null;
        MedicinesDTO dto = new MedicinesDTO();
        dto.setId(medicines.getId());
        dto.setMedicationName(medicines.getMedicationName());
        dto.setMedicationCode(medicines.getMedicationCode());
        dto.setMedicineType(medicines.getMedicineType());
        dto.setIsActive(medicines.getIsActive());
        return dto;
    }

    private Medicines convertToEntity(MedicinesDTO dto) {
        if (dto == null) return null;
        Medicines medicines = new Medicines();
        medicines.setId(dto.getId());
        medicines.setMedicationName(dto.getMedicationName());
        medicines.setMedicationCode(dto.getMedicationCode());
        medicines.setMedicineType(dto.getMedicineType());
        medicines.setIsActive(dto.getIsActive());
        return medicines;
    }
}
