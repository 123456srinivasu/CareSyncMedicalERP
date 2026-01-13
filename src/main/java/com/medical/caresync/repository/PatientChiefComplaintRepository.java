package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientChiefComplaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientChiefComplaintRepository
        extends JpaRepository<PatientChiefComplaint, Long> {
    Optional<PatientChiefComplaint>
    findTopByPatientConsultation_PatientConsultationIdOrderByCreationTsDesc(
            Long patientConsultationId
    );
}
