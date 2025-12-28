package com.medical.caresync.service;

import com.medical.caresync.dto.DietCounsellingDTO;
import com.medical.caresync.entities.DietCounselling;
import com.medical.caresync.repository.DietCounsellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DietCounsellingService {

    @Autowired
    private DietCounsellingRepository dietCounsellingRepository;

    public List<DietCounsellingDTO> getAllDietCounsellings() {
        return dietCounsellingRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DietCounsellingDTO createDietCounselling(DietCounsellingDTO dietCounsellingDTO) {
        DietCounselling dietCounselling = convertToEntity(dietCounsellingDTO);
        dietCounselling = dietCounsellingRepository.save(dietCounselling);
        return convertToDTO(dietCounselling);
    }

    private DietCounsellingDTO convertToDTO(DietCounselling dietCounselling) {
        DietCounsellingDTO dto = new DietCounsellingDTO();
        dto.setId(dietCounselling.getId());
        return dto;
    }

    private DietCounselling convertToEntity(DietCounsellingDTO dto) {
        DietCounselling dietCounselling = new DietCounselling();
        dietCounselling.setId(dto.getId());
        return dietCounselling;
    }
}
