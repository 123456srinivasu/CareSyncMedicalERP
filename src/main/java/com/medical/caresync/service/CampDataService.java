package com.medical.caresync.service;

import com.medical.caresync.dto.CampDataDTO;
import com.medical.caresync.entities.CampData;
import com.medical.caresync.repository.CampDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampDataService {

    @Autowired
    private CampDataRepository campDataRepository;

    public List<CampDataDTO> getAllCampData() {
        return campDataRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CampDataDTO createCampData(CampDataDTO campDataDTO) {
        CampData campData = convertToEntity(campDataDTO);
        campData = campDataRepository.save(campData);
        return convertToDTO(campData);
    }

    private CampDataDTO convertToDTO(CampData campData) {
        CampDataDTO dto = new CampDataDTO();
        dto.setId(campData.getId());
        return dto;
    }

    private CampData convertToEntity(CampDataDTO dto) {
        CampData campData = new CampData();
        campData.setId(dto.getId());
        return campData;
    }
}
