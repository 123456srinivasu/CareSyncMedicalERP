package com.medical.caresync.service;

import com.medical.caresync.dto.PatientSearchDTO;
import com.medical.caresync.entities.PatientSearch;
import com.medical.caresync.repository.PatientSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientSearchService {

    @Autowired
    private PatientSearchRepository patientSearchRepository;

    public List<PatientSearchDTO> getAllPatientSearchs() {
        return patientSearchRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientSearchDTO createPatientSearch(PatientSearchDTO patientSearchDTO) {
        PatientSearch patientSearch = convertToEntity(patientSearchDTO);
        patientSearch = patientSearchRepository.save(patientSearch);
        return convertToDTO(patientSearch);
    }

    private PatientSearchDTO convertToDTO(PatientSearch patientSearch) {
        PatientSearchDTO dto = new PatientSearchDTO();
        dto.setId(patientSearch.getId());
        return dto;
    }

    private PatientSearch convertToEntity(PatientSearchDTO dto) {
        PatientSearch patientSearch = new PatientSearch();
        patientSearch.setId(dto.getId());
        return patientSearch;
    }
}
