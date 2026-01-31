package com.medical.caresync.service;

import com.medical.caresync.dto.*;
import com.medical.caresync.entities.*;
import com.medical.caresync.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientVisitService {

    @Autowired
    private PatientRegistrationRepository patientRegistrationRepository;

    @Autowired
    private PatientConsultationRepository patientConsultationRepository;

    @Autowired
    private CampPharmacyStockTxnRepository campPharmacyStockTxnRepository;

    @Autowired
    private UsersRepository usersRepository;

    public PatientVisitHistoryDTO getPatientVisitHistory(String mrNumber) {
        // 1. Find Patient
        Patient patient = patientRegistrationRepository.findByMrNumber(mrNumber);
        if (patient == null) {
            return null; // Or throw exception
        }

        // 2. Find Consultations
        List<PatientConsultation> consultations = patientConsultationRepository.findByPatient_TblPatientId(patient.getTblPatientId());

        // 3. Transform to DTOs
        PatientVisitHistoryDTO historyDTO = new PatientVisitHistoryDTO();
        historyDTO.setMrNumber(patient.getMrNumber());
        historyDTO.setPatientName(patient.getFirstNm()); 
        historyDTO.setTotalCampsAttended(consultations.size());

        List<CampVisitDTO> campVisits = consultations.stream().map(consultation -> {
            CampVisitDTO visitDTO = new CampVisitDTO();
            
            // Set Camp Details
            if (consultation.getCampRuns() != null && consultation.getCampRuns().getCamps() != null) {
                visitDTO.setCampId(consultation.getCampRuns().getCamps().getCampId());
                visitDTO.setCampName(consultation.getCampRuns().getCamps().getCampName());
                visitDTO.setCampDate(consultation.getCampRuns().getPlannedDate());
            }

            // Set Doctor Name (fetch from Users if possible, else use ID/Name from consultation)
            if (consultation.getDoctorId() != null) {
                usersRepository.findById(consultation.getDoctorId()).ifPresent(user -> 
                    visitDTO.setDoctorName("Dr. " + user.getFirstName() + " " + user.getLastName())
                );
            }
            
            visitDTO.setDiagnosis(consultation.getDiagnosis());

            // Set Medicines
            List<CampPharmacyStockTxn> pharmacyTxns = campPharmacyStockTxnRepository.findByPatientConsultation_PatientConsultationId(consultation.getPatientConsultationId());
            
            List<PrescribedMedicineDTO> medicineDTOs = pharmacyTxns.stream().map(txn -> {
                PrescribedMedicineDTO med = new PrescribedMedicineDTO();
                if (txn.getMedicine() != null) {
                    med.setMedicineName(txn.getMedicine().getMedicationName());
                }
                med.setQuantity(txn.getQuantityChange() != null ? Math.abs(txn.getQuantityChange()) : 0);
                // Placeholder logic for dosage/days as specific columns might be missing or in 'remarks'
                med.setDosage("As prescribed"); 
                med.setDays(0); 
                return med;
            }).collect(Collectors.toList());

            visitDTO.setMedicines(medicineDTOs);
            return visitDTO;

        }).collect(Collectors.toList());

        historyDTO.setCamps(campVisits);
        return historyDTO;
    }
}
