package com.medical.caresync.service;

import com.medical.caresync.dto.PatientAmountDTO;
import com.medical.caresync.entities.PatientAmount;
import com.medical.caresync.repository.PatientAmountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientAmountService {

    @Autowired
    private PatientAmountRepository patientAmountRepository;

    public List<PatientAmountDTO> getAllPatientAmounts() {
        return patientAmountRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientAmountDTO createPatientAmount(PatientAmountDTO patientAmountDTO) {
        PatientAmount patientAmount = convertToEntity(patientAmountDTO);
        patientAmount = patientAmountRepository.save(patientAmount);
        return convertToDTO(patientAmount);
    }

    private PatientAmountDTO convertToDTO(PatientAmount patientAmount) {
        PatientAmountDTO dto = new PatientAmountDTO();
        dto.setId(patientAmount.getId());
        return dto;
    }

    private PatientAmount convertToEntity(PatientAmountDTO dto) {
        PatientAmount patientAmount = new PatientAmount();
        patientAmount.setId(dto.getId());
        return patientAmount;
    }
}
