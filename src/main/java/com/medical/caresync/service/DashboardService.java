package com.medical.caresync.service;

import com.medical.caresync.dto.DashboardSummaryDTO;
import com.medical.caresync.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private CampsRepository campsRepository;

    @Autowired
    private PatientRegistrationRepository patientRegistrationRepository;

    @Autowired
    private MedicineLookupNewRepository medicineLookupNewRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PatientDiscountRepository patientDiscountRepository;

    @Autowired
    private CampDiagnosisReportRepository campDiagnosisReportRepository;

    public DashboardSummaryDTO getSummary() {
        DashboardSummaryDTO summary = new DashboardSummaryDTO();

        summary.setCampsCount(campsRepository.count());
        summary.setPatientsCount(patientRegistrationRepository.count());
        summary.setMedicinesCount(medicineLookupNewRepository.count());
        summary.setDoctorsCount(usersRepository.findUsersByRoleName("DOCTOR").size());
        summary.setDiscountsCount(patientDiscountRepository.count());
        summary.setIllnessCount(campDiagnosisReportRepository.countDistinctDiagnosis());

        return summary;
    }
}
