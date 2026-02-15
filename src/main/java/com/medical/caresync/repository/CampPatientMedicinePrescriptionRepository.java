package com.medical.caresync.repository;

import com.medical.caresync.entities.CampPatientMedicinePrescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampPatientMedicinePrescriptionRepository extends JpaRepository<CampPatientMedicinePrescription, Long> {

    List<CampPatientMedicinePrescription> findByCamps_CampId(Long campId);

    List<CampPatientMedicinePrescription> findByPatient_TblPatientId(Long patientId);

    List<CampPatientMedicinePrescription> findByCamps_CampIdAndPatient_TblPatientId(Long campId, Long patientId);

    List<CampPatientMedicinePrescription> findByPatient_TblPatientIdAndIsActive(Long patientId, Boolean isActive);
}
