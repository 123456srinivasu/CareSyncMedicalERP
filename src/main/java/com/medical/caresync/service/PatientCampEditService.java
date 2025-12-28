package com.medical.caresync.service;

import com.medical.caresync.dto.PatientCampEditDTO;
import com.medical.caresync.entities.PatientCampEdit;
import com.medical.caresync.repository.PatientCampEditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientCampEditService {

    @Autowired
    private PatientCampEditRepository patientCampEditRepository;

    public List<PatientCampEditDTO> getAllPatientCampEdits() {
        return patientCampEditRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientCampEditDTO createPatientCampEdit(PatientCampEditDTO patientCampEditDTO) {
        PatientCampEdit patientCampEdit = convertToEntity(patientCampEditDTO);
        patientCampEdit = patientCampEditRepository.save(patientCampEdit);
        return convertToDTO(patientCampEdit);
    }

    private PatientCampEditDTO convertToDTO(PatientCampEdit patientCampEdit) {
        PatientCampEditDTO dto = new PatientCampEditDTO();
        dto.setId(patientCampEdit.getId());
        return dto;
    }

    private PatientCampEdit convertToEntity(PatientCampEditDTO dto) {
        PatientCampEdit patientCampEdit = new PatientCampEdit();
        patientCampEdit.setId(dto.getId());
        return patientCampEdit;
    }
}
