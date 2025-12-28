package com.medical.caresync.service;

import com.medical.caresync.dto.PatientCampDTO;
import com.medical.caresync.entities.PatientCamp;
import com.medical.caresync.repository.PatientCampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientCampService {

    @Autowired
    private PatientCampRepository patientCampRepository;

    public List<PatientCampDTO> getAllPatientCamps() {
        return patientCampRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientCampDTO createPatientCamp(PatientCampDTO patientCampDTO) {
        PatientCamp patientCamp = convertToEntity(patientCampDTO);
        patientCamp = patientCampRepository.save(patientCamp);
        return convertToDTO(patientCamp);
    }

    private PatientCampDTO convertToDTO(PatientCamp patientCamp) {
        PatientCampDTO dto = new PatientCampDTO();
        dto.setId(patientCamp.getId());
        return dto;
    }

    private PatientCamp convertToEntity(PatientCampDTO dto) {
        PatientCamp patientCamp = new PatientCamp();
        patientCamp.setId(dto.getId());
        return patientCamp;
    }
}
