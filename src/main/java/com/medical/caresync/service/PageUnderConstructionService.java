package com.medical.caresync.service;

import com.medical.caresync.dto.PageUnderConstructionDTO;
import com.medical.caresync.entities.PageUnderConstruction;
import com.medical.caresync.repository.PageUnderConstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageUnderConstructionService {

    @Autowired
    private PageUnderConstructionRepository pageUnderConstructionRepository;

    public List<PageUnderConstructionDTO> getAllPageUnderConstructions() {
        return pageUnderConstructionRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PageUnderConstructionDTO createPageUnderConstruction(PageUnderConstructionDTO pageUnderConstructionDTO) {
        PageUnderConstruction pageUnderConstruction = convertToEntity(pageUnderConstructionDTO);
        pageUnderConstruction = pageUnderConstructionRepository.save(pageUnderConstruction);
        return convertToDTO(pageUnderConstruction);
    }

    private PageUnderConstructionDTO convertToDTO(PageUnderConstruction pageUnderConstruction) {
        PageUnderConstructionDTO dto = new PageUnderConstructionDTO();
        dto.setId(pageUnderConstruction.getId());
        return dto;
    }

    private PageUnderConstruction convertToEntity(PageUnderConstructionDTO dto) {
        PageUnderConstruction pageUnderConstruction = new PageUnderConstruction();
        pageUnderConstruction.setId(dto.getId());
        return pageUnderConstruction;
    }
}
