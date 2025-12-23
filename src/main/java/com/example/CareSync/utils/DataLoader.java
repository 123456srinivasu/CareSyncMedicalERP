package com.example.CareSync.utils;

import com.example.CareSync.entities.Patient;
import com.example.CareSync.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PatientRepository patientRepository;

    public DataLoader(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient("John", "Doe", 30, "john.doe@example.com"));
        patientRepository.save(new Patient("Jane", "Smith", 28, "jane.smith@example.com"));
        patientRepository.save(new Patient("Alice", "Johnson", 45, "alice.j@example.com"));
    }
}
