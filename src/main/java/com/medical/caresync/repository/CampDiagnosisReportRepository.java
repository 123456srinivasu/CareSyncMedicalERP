package com.medical.caresync.repository;

import com.medical.caresync.entities.CampDiagnosisReport;
import com.medical.caresync.dto.CampDiagnosisReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface CampDiagnosisReportRepository extends JpaRepository<CampDiagnosisReport, Long> {
    @Query("SELECT new com.medical.caresync.dto.CampDiagnosisReportDTO(r.patient.firstNm, r.patient.lastNm, r.patient.enrollmentId, r.reportData) " +
           "FROM CampDiagnosisReport r " +
           "WHERE r.diagnosis LIKE %:diagnosis% " +
           "AND (:campId IS NULL OR r.campDetail.tblCamp.tblCampId = :campId)")
    List<CampDiagnosisReportDTO> findByDiagnosis(@Param("diagnosis") String diagnosis, @Param("campId") Integer campId);
}
