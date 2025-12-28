package com.medical.caresync.service;

import com.medical.caresync.dto.PatientMedicalProcessDTO;
import com.medical.caresync.entities.PatientMedicalProcess;
import com.medical.caresync.repository.PatientMedicalProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientMedicalProcessService {

    @Autowired
    private PatientMedicalProcessRepository patientMedicalProcessRepository;

    public List<PatientMedicalProcessDTO> getAllPatientMedicalProcesses() {
        return patientMedicalProcessRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientMedicalProcessDTO createPatientMedicalProcess(PatientMedicalProcessDTO patientMedicalProcessDTO) {
        PatientMedicalProcess patientMedicalProcess = convertToEntity(patientMedicalProcessDTO);
        patientMedicalProcess = patientMedicalProcessRepository.save(patientMedicalProcess);
        return convertToDTO(patientMedicalProcess);
    }

    private PatientMedicalProcessDTO convertToDTO(PatientMedicalProcess patientMedicalProcess) {
        PatientMedicalProcessDTO dto = new PatientMedicalProcessDTO();
        dto.setId(patientMedicalProcess.getId());
        return dto;
    }

    private PatientMedicalProcess convertToEntity(PatientMedicalProcessDTO dto) {
        PatientMedicalProcess patientMedicalProcess = new PatientMedicalProcess();
        patientMedicalProcess.setId(dto.getId());
        return patientMedicalProcess;
    }
}
