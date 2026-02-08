package com.medical.caresync.service;

import com.medical.caresync.dto.CampPatientAnswerRequestDTO;
import com.medical.caresync.dto.CampPatientAnswerResponseDTO;
import com.medical.caresync.entities.*;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampPatientAnswerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampPatientAnswerService.class);

    @Autowired
    private CampPatientAnswerRepository campPatientAnswerRepository;

    @Autowired
    private CampsRepository campsRepository;

    @Autowired
    private PatientRegistrationRepository patientRegistrationRepository;

    @Autowired
    private CampQuestionRepository campQuestionRepository;

    @Autowired
    private CampQuestionOptionRepository campQuestionOptionRepository;

    @Transactional
    public CampPatientAnswerResponseDTO savePatientAnswers(CampPatientAnswerRequestDTO requestDTO) {
        LOGGER.info("Saving patient answers for campId: {}, patientId: {}", 
                requestDTO.getCampId(), requestDTO.getPatientId());

        // Validate camp exists
        Camps camp = campsRepository.findById(requestDTO.getCampId())
                .orElseThrow(() -> new BadRequestException("Camp not found with ID: " + requestDTO.getCampId()));

        // Validate patient exists
        Patient patient = patientRegistrationRepository.findById(requestDTO.getPatientId())
                .orElseThrow(() -> new BadRequestException("Patient not found with ID: " + requestDTO.getPatientId()));


        List<CampPatientAnswer> answersToSave = new ArrayList<>();

        for (CampPatientAnswerRequestDTO.AnswerDTO answerDTO : requestDTO.getAnswers()) {
            // Validate that either optionId or answerText is present
            if ((answerDTO.getOptionId() == null || answerDTO.getOptionId() == 0) && 
                (answerDTO.getAnswerText() == null || answerDTO.getAnswerText().trim().isEmpty())) {
                throw new BadRequestException(
                    "Either optionId or answerText must be provided for question ID: " + answerDTO.getQuestionId()
                );
            }

            // Validate question exists
            CampQuestion question = campQuestionRepository.findById(answerDTO.getQuestionId())
                    .orElseThrow(() -> new BadRequestException("Question not found with ID: " + answerDTO.getQuestionId()));

            CampQuestionOption option = null;
            // Validate option exists if optionId is provided
            if (answerDTO.getOptionId() != null && answerDTO.getOptionId() > 0) {
                option = campQuestionOptionRepository.findById(answerDTO.getOptionId())
                        .orElseThrow(() -> new BadRequestException("Option not found with ID: " + answerDTO.getOptionId()));
            }

            // Create and populate the answer entity
            CampPatientAnswer answer = new CampPatientAnswer();
            answer.setCamp(camp);
            answer.setPatient(patient);
            answer.setQuestion(question);
            answer.setAnswerText(answerDTO.getAnswerText());
            answer.setOption(option);

            answersToSave.add(answer);
        }

        // Save all answers in a single transaction
        List<CampPatientAnswer> savedAnswers = campPatientAnswerRepository.saveAll(answersToSave);

        LOGGER.info("Successfully saved {} answers for campId: {}, patientId: {}", 
                savedAnswers.size(), requestDTO.getCampId(), requestDTO.getPatientId());

        return new CampPatientAnswerResponseDTO(
                "Patient answers saved successfully",
                savedAnswers.size(),
                requestDTO.getCampId(),
                requestDTO.getPatientId()
        );
    }
}
