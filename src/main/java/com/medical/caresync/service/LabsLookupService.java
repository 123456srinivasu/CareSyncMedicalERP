package com.medical.caresync.service;

import com.medical.caresync.dto.LabsLookupDTO;
import com.medical.caresync.entities.LabsLookup;
import com.medical.caresync.repository.LabsLookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabsLookupService {
    @Autowired
    private LabsLookupRepository labsLookupRepository;

    public List<LabsLookupDTO> getAllLabs() {
        return labsLookupRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private LabsLookupDTO toDTO(LabsLookup entity) {
        LabsLookupDTO dto = new LabsLookupDTO();
        dto.setId(entity.getId());
        dto.setLabTestName(entity.getLabTestName());
        dto.setDescription(entity.getDescription());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }
}
