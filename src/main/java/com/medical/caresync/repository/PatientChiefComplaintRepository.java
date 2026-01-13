package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientChiefComplaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientChiefComplaintRepository
        extends JpaRepository<PatientChiefComplaint, Long> {
}
