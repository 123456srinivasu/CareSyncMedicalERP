package com.medical.caresync.repository;

import com.medical.caresync.entities.CampQuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampQuestionOptionRepository extends JpaRepository<CampQuestionOption, Long> {
}
