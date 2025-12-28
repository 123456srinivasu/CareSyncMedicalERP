package com.medical.caresync.service;

import com.medical.caresync.dto.DiabetesDTO;
import com.medical.caresync.entities.Diabetes;
import com.medical.caresync.repository.DiabetesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiabetesService {

    @Autowired
    private DiabetesRepository diabetesRepository;

    public List<DiabetesDTO> getAllDiabetes() {
        return diabetesRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DiabetesDTO createDiabetes(DiabetesDTO diabetesDTO) {
        Diabetes diabetes = convertToEntity(diabetesDTO);
        diabetes = diabetesRepository.save(diabetes);
        return convertToDTO(diabetes);
    }

    private DiabetesDTO convertToDTO(Diabetes diabetes) {
        DiabetesDTO dto = new DiabetesDTO();
        dto.setId(diabetes.getId());
        return dto;
    }

    private Diabetes convertToEntity(DiabetesDTO dto) {
        Diabetes diabetes = new Diabetes();
        diabetes.setId(dto.getId());
        return diabetes;
    }
}
