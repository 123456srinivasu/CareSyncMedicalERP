package com.medical.caresync.service;

import com.medical.caresync.dto.PatientMaternityDetailsDTO;
import com.medical.caresync.entities.PatientMaternityDetails;
import com.medical.caresync.repository.PatientMaternityDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientMaternityDetailsService {

    @Autowired
    private PatientMaternityDetailsRepository patientMaternityDetailsRepository;

    public List<PatientMaternityDetailsDTO> getAllPatientMaternityDetailss() {
        return patientMaternityDetailsRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientMaternityDetailsDTO createPatientMaternityDetails(PatientMaternityDetailsDTO patientMaternityDetailsDTO) {
        PatientMaternityDetails patientMaternityDetails = convertToEntity(patientMaternityDetailsDTO);
        patientMaternityDetails = patientMaternityDetailsRepository.save(patientMaternityDetails);
        return convertToDTO(patientMaternityDetails);
    }

    private PatientMaternityDetailsDTO convertToDTO(PatientMaternityDetails patientMaternityDetails) {
        PatientMaternityDetailsDTO dto = new PatientMaternityDetailsDTO();
        dto.setId(patientMaternityDetails.getId());
        return dto;
    }

    private PatientMaternityDetails convertToEntity(PatientMaternityDetailsDTO dto) {
        PatientMaternityDetails patientMaternityDetails = new PatientMaternityDetails();
        patientMaternityDetails.setId(dto.getId());
        return patientMaternityDetails;
    }
}
