package com.medical.caresync.service;

import com.medical.caresync.dto.CampQuestionDTO;
import com.medical.caresync.dto.CampQuestionOptionDTO;
import com.medical.caresync.entities.CampQuestion;
import com.medical.caresync.entities.CampQuestionFlow;
import com.medical.caresync.entities.CampQuestionOption;
import com.medical.caresync.repository.CampQuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CampQuestionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampQuestionService.class);

    @Autowired
    private CampQuestionRepository campQuestionRepository;

    @Transactional(readOnly = true)
    public List<CampQuestionDTO> getAllQuestionsWithOptions() {
        LOGGER.info("Fetching all active camp questions with options and flows");

        List<CampQuestion> questions = campQuestionRepository.findAllActiveQuestionsWithDetails();
        
        return questions.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CampQuestionDTO mapToDTO(CampQuestion question) {
        // Create a map to store option ID to next question ID mapping from flows
        Map<Long, Long> optionFlowMap = new HashMap<>();
        
        if (question.getFlows() != null) {
            for (CampQuestionFlow flow : question.getFlows()) {
                if (flow.getOption() != null && flow.getIsActive() != null && flow.getIsActive()) {
                    optionFlowMap.put(flow.getOption().getOptionId(), flow.getNextQuestionId());
                }
            }
        }

        // Map options with their next question IDs
        List<CampQuestionOptionDTO> optionDTOs = new ArrayList<>();
        if (question.getOptions() != null) {
            optionDTOs = question.getOptions().stream()
                    .sorted(Comparator.comparing(
                            opt -> opt.getSortOrder() != null ? opt.getSortOrder() : Integer.MAX_VALUE
                    ))
                    .map(option -> new CampQuestionOptionDTO(
                            option.getOptionId(),
                            option.getOptionText(),
                            optionFlowMap.get(option.getOptionId())
                    ))
                    .collect(Collectors.toList());
        }

        return new CampQuestionDTO(
                question.getQuestionId(),
                question.getQuestionText(),
                question.getQuestionType(),
                question.getQuestionsCategory(),
                question.getDefaultDisplay(),
                optionDTOs
        );
    }
}
