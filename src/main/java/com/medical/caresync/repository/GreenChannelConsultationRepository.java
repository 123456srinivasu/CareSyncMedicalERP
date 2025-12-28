package com.medical.caresync.repository;

import com.medical.caresync.entities.GreenChannelConsultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreenChannelConsultationRepository extends JpaRepository<GreenChannelConsultation, Long> {
}
