package com.medical.caresync.service;

import com.medical.caresync.dto.AssessmentNotesRequestDTO;
import com.medical.caresync.dto.AssessmentNotesResponseDTO;
import com.medical.caresync.entities.*;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CampPatientAssessmentNotesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampPatientAssessmentNotesService.class);

    @Autowired
    private CampPatientAssessmentNotesRepository assessmentNotesRepository;

    @Autowired
    private CampsRepository campsRepository;

    @Autowired
    private PatientRegistrationRepository patientRegistrationRepository;

    @Autowired
    private PatientConsultationRepository patientConsultationRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public AssessmentNotesResponseDTO saveAssessmentNotes(AssessmentNotesRequestDTO requestDTO) {
        LOGGER.info("Saving assessment notes for campId: {}, patientId: {}", 
                requestDTO.getCampId(), requestDTO.getPatientId());

        // Validate camp exists
        Camps camp = campsRepository.findById(requestDTO.getCampId())
                .orElseThrow(() -> new BadRequestException("Camp not found with ID: " + requestDTO.getCampId()));

        // Validate patient exists
        Patient patient = patientRegistrationRepository.findById(requestDTO.getPatientId())
                .orElseThrow(() -> new BadRequestException("Patient not found with ID: " + requestDTO.getPatientId()));

        // Validate patient consultation if provided
        PatientConsultation patientConsultation = null;
        if (requestDTO.getPatientConsultationId() != null) {
            patientConsultation = patientConsultationRepository.findById(requestDTO.getPatientConsultationId())
                    .orElseThrow(() -> new BadRequestException("Patient consultation not found with ID: " + requestDTO.getPatientConsultationId()));
        }

        // Validate and fetch user if createdById is provided
        Users createdByUser = null;
        if (requestDTO.getCreatedById() != null) {
            createdByUser = usersRepository.findById(requestDTO.getCreatedById())
                    .orElseThrow(() -> new BadRequestException("User not found with ID: " + requestDTO.getCreatedById()));
        }

        // Validate notes not empty
        if (requestDTO.getNotes() == null || requestDTO.getNotes().trim().isEmpty()) {
            throw new BadRequestException("Assessment notes cannot be empty");
        }

        // Create and populate the assessment notes entity
        CampPatientAssessmentNotes assessmentNotes = new CampPatientAssessmentNotes();
        assessmentNotes.setCamp(camp);
        assessmentNotes.setPatient(patient);
        assessmentNotes.setPatientConsultation(patientConsultation);
        assessmentNotes.setAssessmentNotesType(requestDTO.getAssessmentNotesType());
        assessmentNotes.setNotes(requestDTO.getNotes());
        assessmentNotes.setCreatedBy(createdByUser);

        // Save the assessment notes
        CampPatientAssessmentNotes savedNotes = assessmentNotesRepository.save(assessmentNotes);

        LOGGER.info("Successfully saved assessment notes with ID: {} for campId: {}, patientId: {}", 
                savedNotes.getAssessmentId(), requestDTO.getCampId(), requestDTO.getPatientId());

        return new AssessmentNotesResponseDTO(
                "Assessment notes saved successfully",
                savedNotes.getAssessmentId(),
                requestDTO.getCampId(),
                requestDTO.getPatientId()
        );
    }
}
