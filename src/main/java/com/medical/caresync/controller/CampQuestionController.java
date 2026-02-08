package com.medical.caresync.controller;

import com.medical.caresync.dto.CampQuestionDTO;
import com.medical.caresync.service.CampQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camp-questions")
public class CampQuestionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampQuestionController.class);

    @Autowired
    private CampQuestionService campQuestionService;

    @GetMapping
    public ResponseEntity<List<CampQuestionDTO>> getAllQuestions() {
        try {
            LOGGER.info("Received request to fetch all camp questions");
            List<CampQuestionDTO> questions = campQuestionService.getAllQuestionsWithOptions();
            LOGGER.info("Successfully fetched {} camp questions", questions.size());
            return ResponseEntity.ok(questions);
        } catch (Exception e) {
            LOGGER.error("Error fetching camp questions", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
