package com.medical.caresync.service;

import com.medical.caresync.dto.CampDayDTO;
import com.medical.caresync.entities.CampDay;
import com.medical.caresync.repository.CampDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampDayService {

    @Autowired
    private CampDayRepository campDayRepository;

    public List<CampDayDTO> getAllCampDays() {
        return campDayRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CampDayDTO createCampDay(CampDayDTO campDayDTO) {
        CampDay campDay = convertToEntity(campDayDTO);
        campDay = campDayRepository.save(campDay);
        return convertToDTO(campDay);
    }

    private CampDayDTO convertToDTO(CampDay campDay) {
        CampDayDTO dto = new CampDayDTO();
        dto.setId(campDay.getId());
        return dto;
    }

    private CampDay convertToEntity(CampDayDTO dto) {
        CampDay campDay = new CampDay();
        campDay.setId(dto.getId());
        return campDay;
    }
}
