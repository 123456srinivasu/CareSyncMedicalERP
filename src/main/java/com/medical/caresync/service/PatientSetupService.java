package com.medical.caresync.service;

import com.medical.caresync.dto.PatientSetupDTO;
import com.medical.caresync.entities.PatientSetup;
import com.medical.caresync.repository.PatientSetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientSetupService {

    @Autowired
    private PatientSetupRepository patientSetupRepository;

    public List<PatientSetupDTO> getAllPatientSetups() {
        return patientSetupRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientSetupDTO createPatientSetup(PatientSetupDTO patientSetupDTO) {
        PatientSetup patientSetup = convertToEntity(patientSetupDTO);
        patientSetup = patientSetupRepository.save(patientSetup);
        return convertToDTO(patientSetup);
    }

    private PatientSetupDTO convertToDTO(PatientSetup patientSetup) {
        PatientSetupDTO dto = new PatientSetupDTO();
        dto.setId(patientSetup.getId());
        return dto;
    }

    private PatientSetup convertToEntity(PatientSetupDTO dto) {
        PatientSetup patientSetup = new PatientSetup();
        patientSetup.setId(dto.getId());
        return patientSetup;
    }
}
