package com.medical.caresync.service;

import com.medical.caresync.dto.PatientInsulinDTO;
import com.medical.caresync.entities.PatientInsulin;
import com.medical.caresync.repository.PatientInsulinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientInsulinService {

    @Autowired
    private PatientInsulinRepository patientInsulinRepository;

    public List<PatientInsulinDTO> getAllPatientInsulins() {
        return patientInsulinRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientInsulinDTO createPatientInsulin(PatientInsulinDTO patientInsulinDTO) {
        PatientInsulin patientInsulin = convertToEntity(patientInsulinDTO);
        patientInsulin = patientInsulinRepository.save(patientInsulin);
        return convertToDTO(patientInsulin);
    }

    private PatientInsulinDTO convertToDTO(PatientInsulin patientInsulin) {
        PatientInsulinDTO dto = new PatientInsulinDTO();
        dto.setId(patientInsulin.getId());
        return dto;
    }

    private PatientInsulin convertToEntity(PatientInsulinDTO dto) {
        PatientInsulin patientInsulin = new PatientInsulin();
        patientInsulin.setId(dto.getId());
        return patientInsulin;
    }
}
