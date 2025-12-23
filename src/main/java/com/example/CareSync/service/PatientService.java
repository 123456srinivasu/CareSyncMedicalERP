package com.example.CareSync.service;

import com.example.CareSync.dto.PatientDTO;
import com.example.CareSync.entities.Patient;
import com.example.CareSync.repository.PatientRepository;
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
        Iterable<Patient> iterable = patientRepository.findAll();
        List<PatientDTO> result = new ArrayList<>();
        for (Patient p : iterable) {
            result.add(mapToDTO(p));
        }
        return result;
    }

    private PatientDTO mapToDTO(Patient p) {
        return new PatientDTO(p.getId(), p.getFirstName(), p.getLastName(), p.getAge(), p.getEmail());
    }
}
