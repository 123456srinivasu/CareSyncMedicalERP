package com.medical.caresync.repository;

import com.medical.caresync.entities.CampMedicinesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.caresync.entities.CampMedicinesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CampMedicinesReportRepository extends JpaRepository<CampMedicinesReport, Long> {
    @Query("SELECT new com.medical.caresync.dto.CampMedicinesReportDTO(" +
            "cmr.id, " +
            "cmr.medicine.medicineNm, " +
            "cmr.patient.firstNm, " +
            "cmr.patient.lastNm, " +
            "cmr.campDetail.campStartDt, " +
            "cmr.morning, " +
            "cmr.afternoon, " +
            "cmr.night, " +
            "cmr.quantityIssued) " +
            "FROM CampMedicinesReport cmr " +
            "WHERE cmr.medicine.id = :medicineId " +
            "ORDER BY cmr.campDetail.campStartDt DESC, cmr.patient.firstNm ASC")
    List<com.medical.caresync.dto.CampMedicinesReportDTO> findByMedicineId(@Param("medicineId") Long medicineId);
    @Query("SELECT COUNT(DISTINCT cmr.patient.id) " +
            "FROM CampMedicinesReport cmr " +
            "WHERE cmr.medicine.id = :medicineId")
    Integer countDistinctPatientsByMedicineId(@Param("medicineId") Long medicineId);
    @Query("SELECT COALESCE(SUM(cmr.quantityIssued), 0) " +
            "FROM CampMedicinesReport cmr " +
            "WHERE cmr.medicine.id = :medicineId")
    Integer sumQuantityIssuedByMedicineId(@Param("medicineId") Long medicineId);
}