package com.medical.caresync.service;

import com.medical.caresync.entities.VitalsLookUp;
import com.medical.caresync.repository.VitalLookUpRepository;
import com.medical.caresync.dto.VitalLookUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VitalLookUpService {
    @Autowired
    private VitalLookUpRepository vitalLookUpRepository;

    public List<VitalLookUpDTO> getAllActiveVitals() {
        return vitalLookUpRepository.findByIsActiveTrue().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private VitalLookUpDTO toDTO(VitalsLookUp entity) {
        VitalLookUpDTO dto = new VitalLookUpDTO();
        dto.setVitalId(entity.getVitalLookupId());
        dto.setVitalName(entity.getVitalName());
        dto.setReferenceRange(entity.getReferenceRange());
        dto.setDescription(entity.getDescription());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }
}
