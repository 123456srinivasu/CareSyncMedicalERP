package com.medical.caresync.repository;

import com.medical.caresync.entities.CampQuestionFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampQuestionFlowRepository extends JpaRepository<CampQuestionFlow, Long> {
}
