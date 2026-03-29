package com.medical.caresync.controller;

import com.medical.caresync.dto.UserCredentialsDTO;
import com.medical.caresync.entities.UserCredentials;
import com.medical.caresync.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/credentials")
public class UserCredentialsManagementController {

    private final UserCredentialsService credentialsService;

    @Autowired
    public UserCredentialsManagementController(UserCredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserCredentials> saveCredentials(@RequestBody UserCredentialsDTO credentialsDTO) {
        try {
            UserCredentials result = credentialsService.saveCredentials(credentialsDTO);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
             return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<UserCredentials> updateCredentials(@RequestBody UserCredentialsDTO credentialsDTO) {
        try {
            UserCredentials result = credentialsService.saveCredentials(credentialsDTO);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
