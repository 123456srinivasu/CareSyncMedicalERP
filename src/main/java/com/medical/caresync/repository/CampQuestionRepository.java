package com.medical.caresync.repository;

import com.medical.caresync.entities.CampQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampQuestionRepository extends JpaRepository<CampQuestion, Long> {

    @Query("""
        SELECT DISTINCT q
        FROM CampQuestion q
        LEFT JOIN FETCH q.options o
        LEFT JOIN FETCH q.flows f
        WHERE q.isActive = true
        ORDER BY q.questionId
    """)
    List<CampQuestion> findAllActiveQuestionsWithDetails();
}
