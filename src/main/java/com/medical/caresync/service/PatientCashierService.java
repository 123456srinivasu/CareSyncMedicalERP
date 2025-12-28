package com.medical.caresync.service;

import com.medical.caresync.dto.PatientCashierDTO;
import com.medical.caresync.entities.PatientCashier;
import com.medical.caresync.repository.PatientCashierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientCashierService {

    @Autowired
    private PatientCashierRepository patientCashierRepository;

    public List<PatientCashierDTO> getAllPatientCashiers() {
        return patientCashierRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientCashierDTO createPatientCashier(PatientCashierDTO patientCashierDTO) {
        PatientCashier patientCashier = convertToEntity(patientCashierDTO);
        patientCashier = patientCashierRepository.save(patientCashier);
        return convertToDTO(patientCashier);
    }

    private PatientCashierDTO convertToDTO(PatientCashier patientCashier) {
        PatientCashierDTO dto = new PatientCashierDTO();
        dto.setId(patientCashier.getId());
        return dto;
    }

    private PatientCashier convertToEntity(PatientCashierDTO dto) {
        PatientCashier patientCashier = new PatientCashier();
        patientCashier.setId(dto.getId());
        return patientCashier;
    }
}
