package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientTelemedicineMeeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientTelemedicineMeetingRepository extends JpaRepository<PatientTelemedicineMeeting, Long> {
}
