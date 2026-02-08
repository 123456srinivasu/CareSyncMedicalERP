package com.medical.caresync.service;

import com.medical.caresync.dto.PatientLabTestAndVitalsRequestDTO;
import com.medical.caresync.dto.PatientLabTestAndVitalsResponseDTO;
import com.medical.caresync.dto.PatientLabTestDTO;
import com.medical.caresync.dto.PatientVitalDTO;
import com.medical.caresync.entities.Patient;
import com.medical.caresync.entities.PatientLabTests;
import com.medical.caresync.entities.PatientVisit;
import com.medical.caresync.entities.PatientVisitVitals;
import com.medical.caresync.entities.VitalsLookUp;
import com.medical.caresync.repository.PatientLabTestsRepository;
import com.medical.caresync.repository.PatientRegistrationRepository;
import com.medical.caresync.repository.PatientVisitVitalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientLabTestAndVitalsService {

    @Autowired
    private PatientLabTestsRepository labTestsRepository;

    @Autowired
    private PatientVisitVitalsRepository vitalsRepository;

    @Autowired
    private PatientRegistrationRepository patientRepository;

    @Transactional
    public PatientLabTestAndVitalsResponseDTO saveLabTestsAndVitals(PatientLabTestAndVitalsRequestDTO requestDTO) {
        int labTestsSaved = 0;
        int vitalsSaved = 0;
        if (requestDTO.getPatientId() == null) {
            throw new RuntimeException("Patient ID is required");
        }
        // Validate patient and visit exist
        Patient patient = patientRepository.findById(requestDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + requestDTO.getPatientId()));

        // Create PatientVisit reference (assuming it exists)
        PatientVisit patientVisit = new PatientVisit();
        patientVisit.setPatientVisitId(requestDTO.getPatientVisitId());

        // Save Lab Tests
        if (requestDTO.getLabTests() != null && !requestDTO.getLabTests().isEmpty()) {
            List<PatientLabTests> labTestsList = new ArrayList<>();
            for (PatientLabTestDTO labTestDTO : requestDTO.getLabTests()) {
                PatientLabTests labTest = new PatientLabTests();
                labTest.setPatient(patient);
                labTest.setPatientVisit(patientVisit);
                labTest.setLabTestLookupId(labTestDTO.getLabTestLookupId());

                // Parse date if provided
                if (labTestDTO.getLabTestDate() != null && !labTestDTO.getLabTestDate().isEmpty()) {
                    labTest.setLabTestDate(LocalDate.parse(labTestDTO.getLabTestDate()));
                }

                labTest.setTestWithMedicineS(labTestDTO.getTestWithMedicineS());
                labTest.setTestResultValue(labTestDTO.getTestResultValue());
                labTest.setTestResultUnit(labTestDTO.getTestResultUnit());
                labTest.setReferenceValue(labTestDTO.getReferenceValue());
                labTest.setRemark(labTestDTO.getRemark());

                labTestsList.add(labTest);
            }
            labTestsRepository.saveAll(labTestsList);
            labTestsSaved = labTestsList.size();
        }

        // Save Vitals
        if (requestDTO.getVitals() != null && !requestDTO.getVitals().isEmpty()) {
            List<PatientVisitVitals> vitalsList = new ArrayList<>();
            for (PatientVitalDTO vitalDTO : requestDTO.getVitals()) {
                PatientVisitVitals vital = new PatientVisitVitals();
                vital.setPatient(patient);
                vital.setPatientVisit(patientVisit);

                // Create VitalsLookUp reference if provided
                if (vitalDTO.getVitalLookupId() != null) {
                    VitalsLookUp vitalsLookUp = new VitalsLookUp();
                    vitalsLookUp.setVitalLookupId(vitalDTO.getVitalLookupId());
                    vital.setVitalsLookUp(vitalsLookUp);
                }

                vital.setMeasurementType(vitalDTO.getMeasurementType());
                vital.setVitalValue(vitalDTO.getVitalValue());

                vitalsList.add(vital);
            }
            vitalsRepository.saveAll(vitalsList);
            vitalsSaved = vitalsList.size();
        }

        return new PatientLabTestAndVitalsResponseDTO(
                true,
                "Lab tests and vitals saved successfully",
                labTestsSaved,
                vitalsSaved);
    }
}
