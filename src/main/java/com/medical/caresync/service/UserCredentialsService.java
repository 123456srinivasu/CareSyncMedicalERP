package com.medical.caresync.service;

import com.medical.caresync.dto.UserCredentialsDTO;
import com.medical.caresync.entities.UserCredentials;
import com.medical.caresync.entities.Users;
import com.medical.caresync.repository.UserCredentialsRepository;
import com.medical.caresync.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class UserCredentialsService {

    private final UserCredentialsRepository userCredentialsRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public UserCredentialsService(UserCredentialsRepository userCredentialsRepository, UsersRepository usersRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
        this.usersRepository = usersRepository;
    }

    public UserCredentials createCredentials(Long userId, UserCredentials credentials) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));
        
        // Prevent duplicate credentials
        if (userCredentialsRepository.findByUserUserId(userId).isPresent()) {
            throw new RuntimeException("Credentials already exist for user id " + userId);
        }
        
        credentials.setUser(user);
        return userCredentialsRepository.save(credentials);
    }

    @Transactional(readOnly = true)
    public Optional<UserCredentials> getCredentialsByUserId(Long userId) {
        return userCredentialsRepository.findByUserUserId(userId);
    }

    public UserCredentials updateCredentials(Long userId, UserCredentials credentialsDetails) {
        return userCredentialsRepository.findByUserUserId(userId).map(credentials -> {
            credentials.setLoginId(credentialsDetails.getLoginId());
            credentials.setPassword(credentialsDetails.getPassword());
            if (credentialsDetails.getIsActive() != null) {
                credentials.setIsActive(credentialsDetails.getIsActive());
            }
            return userCredentialsRepository.save(credentials);
        }).orElseThrow(() -> new RuntimeException("Credentials not found for user id " + userId));
    }

    public void deactivateCredentials(Long userId) {
        userCredentialsRepository.findByUserUserId(userId).ifPresent(credentials -> {
            credentials.setIsActive(false);
            credentials.setUpdateAt(LocalDateTime.now());
            userCredentialsRepository.save(credentials);
        });
    }

    public UserCredentials saveCredentials(com.medical.caresync.dto.UserCredentialsDTO dto) {
        Users user = usersRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + dto.getUserId()));

        UserCredentials credentials = userCredentialsRepository.findByUserUserId(dto.getUserId())
                .orElse(new UserCredentials());

        credentials.setUser(user);
        credentials.setLoginId(dto.getLoginId());
        credentials.setPassword(dto.getPassword());
        if (dto.getIsActive() != null) {
            credentials.setIsActive(dto.getIsActive());
        }
        
        return userCredentialsRepository.save(credentials);
    }
}
