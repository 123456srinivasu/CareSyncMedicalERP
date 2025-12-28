package com.medical.caresync.service;

import com.medical.caresync.dto.PatientTelemedicineConsultationDTO;
import com.medical.caresync.entities.PatientTelemedicineConsultation;
import com.medical.caresync.repository.PatientTelemedicineConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientTelemedicineConsultationService {

    @Autowired
    private PatientTelemedicineConsultationRepository patientTelemedicineConsultationRepository;

    public List<PatientTelemedicineConsultationDTO> getAllPatientTelemedicineConsultations() {
        return patientTelemedicineConsultationRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientTelemedicineConsultationDTO createPatientTelemedicineConsultation(PatientTelemedicineConsultationDTO patientTelemedicineConsultationDTO) {
        PatientTelemedicineConsultation patientTelemedicineConsultation = convertToEntity(patientTelemedicineConsultationDTO);
        patientTelemedicineConsultation = patientTelemedicineConsultationRepository.save(patientTelemedicineConsultation);
        return convertToDTO(patientTelemedicineConsultation);
    }

    private PatientTelemedicineConsultationDTO convertToDTO(PatientTelemedicineConsultation patientTelemedicineConsultation) {
        PatientTelemedicineConsultationDTO dto = new PatientTelemedicineConsultationDTO();
        dto.setId(patientTelemedicineConsultation.getId());
        return dto;
    }

    private PatientTelemedicineConsultation convertToEntity(PatientTelemedicineConsultationDTO dto) {
        PatientTelemedicineConsultation patientTelemedicineConsultation = new PatientTelemedicineConsultation();
        patientTelemedicineConsultation.setId(dto.getId());
        return patientTelemedicineConsultation;
    }
}
