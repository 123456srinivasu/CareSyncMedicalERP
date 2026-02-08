package com.medical.caresync.controller;

import com.medical.caresync.dto.UserRegistrationDTO;
import com.medical.caresync.entities.Users;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.service.UserRegistrationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-registration")
public class UserRegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        try {
            LOGGER.info("Received user registration request for login ID: {}", userRegistrationDTO.getLoginId());
            Users registeredUser = userRegistrationService.registerUser(userRegistrationDTO);
            LOGGER.info("User registered successfully with ID: {}", registeredUser.getUserId());
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        } catch (BadRequestException ex) {
            LOGGER.error("Bad request during user registration: {}", ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception e) {
            LOGGER.error("Exception during user registration", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred during user registration: " + e.getMessage());
        }
    }
}
