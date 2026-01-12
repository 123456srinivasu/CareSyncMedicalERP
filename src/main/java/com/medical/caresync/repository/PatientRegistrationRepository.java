package com.medical.caresync.repository;

import com.medical.caresync.entities.PatientRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRegistrationRepository extends JpaRepository<PatientRegistration, Long> {
    List<PatientRegistration> findByFirstNameContainingIgnoreCase(String firstName);
    List<PatientRegistration> findByMobileNumber(String mobileNumber);
    List<PatientRegistration> findByMrNumber(String mrNumber);
    List<PatientRegistration> findByTblPatientId(Long tblPatientId);
    List<PatientRegistration> findByFirstNameContainingIgnoreCaseOrMrNumberOrMobileNumberOrTblPatientId(
        String firstName, String mrNumber, String mobileNumber, Long tblPatientId);
}
