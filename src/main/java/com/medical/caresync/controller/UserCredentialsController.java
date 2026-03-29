package com.medical.caresync.controller;

import com.medical.caresync.entities.UserCredentials;
import com.medical.caresync.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/credentials")
public class UserCredentialsController {

    private final UserCredentialsService credentialsService;

    @Autowired
    public UserCredentialsController(UserCredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    @PostMapping
    public ResponseEntity<UserCredentials> createCredentials(@PathVariable Long userId, @RequestBody UserCredentials credentials) {
        try {
            UserCredentials createdCredentials = credentialsService.createCredentials(userId, credentials);
            return ResponseEntity.ok(createdCredentials);
        } catch (RuntimeException e) {
             return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<UserCredentials> getCredentials(@PathVariable Long userId) {
        return credentialsService.getCredentialsByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<UserCredentials> updateCredentials(@PathVariable Long userId, @RequestBody UserCredentials credentials) {
        try {
            UserCredentials updatedCredentials = credentialsService.updateCredentials(userId, credentials);
            return ResponseEntity.ok(updatedCredentials);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deactivateCredentials(@PathVariable Long userId) {
        credentialsService.deactivateCredentials(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<UserCredentials> saveCredentials(@RequestBody com.medical.caresync.dto.UserCredentialsDTO credentialsDTO) {
        try {
            UserCredentials result = credentialsService.saveCredentials(credentialsDTO);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
