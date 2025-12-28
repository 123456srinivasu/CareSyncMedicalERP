package com.medical.caresync.service;

import com.medical.caresync.dto.PatientConsultationDTO;
import com.medical.caresync.entities.PatientConsultation;
import com.medical.caresync.repository.PatientConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientConsultationService {

    @Autowired
    private PatientConsultationRepository patientConsultationRepository;

    public List<PatientConsultationDTO> getAllPatientConsultations() {
        return patientConsultationRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientConsultationDTO createPatientConsultation(PatientConsultationDTO patientConsultationDTO) {
        PatientConsultation patientConsultation = convertToEntity(patientConsultationDTO);
        patientConsultation = patientConsultationRepository.save(patientConsultation);
        return convertToDTO(patientConsultation);
    }

    private PatientConsultationDTO convertToDTO(PatientConsultation patientConsultation) {
        PatientConsultationDTO dto = new PatientConsultationDTO();
        dto.setId(patientConsultation.getId());
        return dto;
    }

    private PatientConsultation convertToEntity(PatientConsultationDTO dto) {
        PatientConsultation patientConsultation = new PatientConsultation();
        patientConsultation.setId(dto.getId());
        return patientConsultation;
    }
}
