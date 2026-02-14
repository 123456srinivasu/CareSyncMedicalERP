package com.medical.caresync.repository;

import com.medical.caresync.entities.CampPatientAssessmentNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampPatientAssessmentNotesRepository extends JpaRepository<CampPatientAssessmentNotes, Long> {
}
