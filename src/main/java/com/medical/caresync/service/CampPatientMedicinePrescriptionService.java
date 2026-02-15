package com.medical.caresync.service;

import com.medical.caresync.dto.CampPatientMedicinePrescriptionRequestDTO;
import com.medical.caresync.dto.CampPatientMedicinePrescriptionResponseDTO;
import com.medical.caresync.entities.*;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampPatientMedicinePrescriptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampPatientMedicinePrescriptionService.class);

    @Autowired
    private CampPatientMedicinePrescriptionRepository prescriptionRepository;

    @Autowired
    private CampsRepository campsRepository;

    @Autowired
    private PatientRegistrationRepository patientRegistrationRepository;

    @Autowired
    private MedicineLookupNewRepository medicineLookupNewRepository;

    @Autowired
    private PatientConsultationRepository patientConsultationRepository;

    @Transactional
    public CampPatientMedicinePrescriptionResponseDTO savePrescription(CampPatientMedicinePrescriptionRequestDTO requestDTO) {
        LOGGER.info("Saving prescription for campId: {}, patientId: {}, medicineId: {}", 
                requestDTO.getCampId(), requestDTO.getPatientId(), requestDTO.getMedicineId());

        // Validate and fetch camp
        Camps camp = campsRepository.findById(requestDTO.getCampId())
                .orElseThrow(() -> new BadRequestException("Camp not found with ID: " + requestDTO.getCampId()));

        // Validate and fetch patient
        Patient patient = patientRegistrationRepository.findById(requestDTO.getPatientId())
                .orElseThrow(() -> new BadRequestException("Patient not found with ID: " + requestDTO.getPatientId()));

        // Validate and fetch medicine
        MedicineLookupNew medicine = medicineLookupNewRepository.findById(requestDTO.getMedicineId())
                .orElseThrow(() -> new BadRequestException("Medicine not found with ID: " + requestDTO.getMedicineId()));

        // Create prescription entity
        CampPatientMedicinePrescription prescription = new CampPatientMedicinePrescription();
        prescription.setCamps(camp);
        prescription.setPatient(patient);
        prescription.setMedicineLookupNew(medicine);
        prescription.setQuantity(requestDTO.getQuantity());
        prescription.setSchedule(requestDTO.getSchedule());
        prescription.setDosage(requestDTO.getDosage());
        prescription.setDurationDays(requestDTO.getDurationDays());
        prescription.setInstructions(requestDTO.getInstructions());
        prescription.setPrescribedBy(requestDTO.getPrescribedBy());
        prescription.setCreatedBy(requestDTO.getCreatedBy());

        // Set patient consultation if provided
        if (requestDTO.getPatientConsultationId() != null) {
            Optional<PatientConsultation> consultation = patientConsultationRepository.findById(requestDTO.getPatientConsultationId());
            consultation.ifPresent(prescription::setPatientConsultation);
        }

        // Save prescription
        CampPatientMedicinePrescription savedPrescription = prescriptionRepository.save(prescription);

        LOGGER.info("Successfully saved prescription with ID: {}", savedPrescription.getPrescriptionId());

        return mapToResponseDTO(savedPrescription);
    }

    @Transactional
    public CampPatientMedicinePrescriptionResponseDTO updatePrescription(Long prescriptionId, 
                                                                          CampPatientMedicinePrescriptionRequestDTO requestDTO) {
        LOGGER.info("Updating prescription ID: {}", prescriptionId);

        // Fetch existing prescription
        CampPatientMedicinePrescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new BadRequestException("Prescription not found with ID: " + prescriptionId));

        // Validate and fetch camp if changed
        if (!prescription.getCamps().getCampId().equals(requestDTO.getCampId())) {
            Camps camp = campsRepository.findById(requestDTO.getCampId())
                    .orElseThrow(() -> new BadRequestException("Camp not found with ID: " + requestDTO.getCampId()));
            prescription.setCamps(camp);
        }

        // Validate and fetch patient if changed
        if (!prescription.getPatient().getTblPatientId().equals(requestDTO.getPatientId())) {
            Patient patient = patientRegistrationRepository.findById(requestDTO.getPatientId())
                    .orElseThrow(() -> new BadRequestException("Patient not found with ID: " + requestDTO.getPatientId()));
            prescription.setPatient(patient);
        }

        // Validate and fetch medicine if changed
        if (!prescription.getMedicineLookupNew().getMedicationId().equals(requestDTO.getMedicineId())) {
            MedicineLookupNew medicine = medicineLookupNewRepository.findById(requestDTO.getMedicineId())
                    .orElseThrow(() -> new BadRequestException("Medicine not found with ID: " + requestDTO.getMedicineId()));
            prescription.setMedicineLookupNew(medicine);
        }

        // Update fields
        prescription.setQuantity(requestDTO.getQuantity());
        prescription.setSchedule(requestDTO.getSchedule());
        prescription.setDosage(requestDTO.getDosage());
        prescription.setDurationDays(requestDTO.getDurationDays());
        prescription.setInstructions(requestDTO.getInstructions());
        prescription.setPrescribedBy(requestDTO.getPrescribedBy());
        prescription.setUpdatedBy(requestDTO.getUpdatedBy());

        // Update patient consultation if provided
        if (requestDTO.getPatientConsultationId() != null) {
            Optional<PatientConsultation> consultation = patientConsultationRepository.findById(requestDTO.getPatientConsultationId());
            consultation.ifPresent(prescription::setPatientConsultation);
        }

        // Save updated prescription
        CampPatientMedicinePrescription updatedPrescription = prescriptionRepository.save(prescription);

        LOGGER.info("Successfully updated prescription ID: {}", prescriptionId);

        return mapToResponseDTO(updatedPrescription);
    }

    @Transactional(readOnly = true)
    public CampPatientMedicinePrescriptionResponseDTO getPrescriptionById(Long prescriptionId) {
        LOGGER.info("Fetching prescription by ID: {}", prescriptionId);

        CampPatientMedicinePrescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new BadRequestException("Prescription not found with ID: " + prescriptionId));

        return mapToResponseDTO(prescription);
    }

    @Transactional(readOnly = true)
    public List<CampPatientMedicinePrescriptionResponseDTO> getPrescriptionsByPatientId(Long patientId) {
        LOGGER.info("Fetching prescriptions for patient ID: {}", patientId);

        List<CampPatientMedicinePrescription> prescriptions = prescriptionRepository.findByPatient_TblPatientId(patientId);

        return prescriptions.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CampPatientMedicinePrescriptionResponseDTO> getPrescriptionsByCampId(Long campId) {
        LOGGER.info("Fetching prescriptions for camp ID: {}", campId);

        List<CampPatientMedicinePrescription> prescriptions = prescriptionRepository.findByCamps_CampId(campId);

        return prescriptions.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private CampPatientMedicinePrescriptionResponseDTO mapToResponseDTO(CampPatientMedicinePrescription prescription) {
        MedicineLookupNew medicine = prescription.getMedicineLookupNew();

        return new CampPatientMedicinePrescriptionResponseDTO(
                prescription.getPrescriptionId(),
                prescription.getCamps() != null ? prescription.getCamps().getCampId() : null,
                prescription.getPatient() != null ? prescription.getPatient().getTblPatientId() : null,
                medicine != null ? medicine.getMedicationId() : null,
                medicine != null ? medicine.getMedicationName() : null,
                medicine != null ? medicine.getMedicationCode() : null,
                medicine != null ? medicine.getMedicineType() : null,
                prescription.getQuantity(),
                prescription.getSchedule(),
                prescription.getDosage(),
                prescription.getDurationDays(),
                prescription.getInstructions(),
                prescription.getPatientConsultation() != null ? prescription.getPatientConsultation().getPatientConsultationId() : null,
                prescription.getPrescribedBy(),
                prescription.getIsActive(),
                prescription.getCreatedAt(),
                prescription.getCreatedBy(),
                prescription.getUpdatedAt(),
                prescription.getUpdatedBy()
        );
    }
}
