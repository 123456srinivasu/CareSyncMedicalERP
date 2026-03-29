package com.medical.caresync.repository;

import com.medical.caresync.entities.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {
    Optional<UserCredentials> findByLoginId(String loginId);
    Optional<UserCredentials> findByUserUserId(Long userId);
}
