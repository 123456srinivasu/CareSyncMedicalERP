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

    public MedicinesDTO createMedicines(MedicinesDTO medicinesDTO) {
        Medicines medicines = convertToEntity(medicinesDTO);
        medicines = medicinesRepository.save(medicines);
        return convertToDTO(medicines);
    }

    private MedicinesDTO convertToDTO(Medicines medicines) {
        MedicinesDTO dto = new MedicinesDTO();
        dto.setId(medicines.getId());
        return dto;
    }

    private Medicines convertToEntity(MedicinesDTO dto) {
        Medicines medicines = new Medicines();
        medicines.setId(dto.getId());
        return medicines;
    }
}
