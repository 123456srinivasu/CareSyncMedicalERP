package com.medical.caresync.repository;

import com.medical.caresync.entities.Amount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AmountRepository extends JpaRepository<Amount, Long> {
    Optional<Amount> findByComponentName(String componentName);
}
