package com.medical.caresync.service;

import com.medical.caresync.dto.PatientDTO;
import com.medical.caresync.entities.Patient;
import com.medical.caresync.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientDTO> getAllPatients() {
        Iterable<Patient> iterable = patientRepository.findPatients();
        List<PatientDTO> result = new ArrayList<>();
        for (Patient p : iterable) {
            result.add(mapToDTO(p));
        }
        return result;
    }

    public org.springframework.data.domain.Page<PatientDTO> getPatientsPage(int page, int size) {
        org.springframework.data.domain.Pageable pageable = org.springframework.data.domain.PageRequest.of(page, size);
        return patientRepository.findAll(pageable).map(this::mapToDTO);
    }

    private PatientDTO mapToDTO(Patient p) {
        return new PatientDTO(p.getTblPatientId(), p.getFirstNm(), p.getLastNm(), p.getAge(), p.getMobileNumber());
    }
}
