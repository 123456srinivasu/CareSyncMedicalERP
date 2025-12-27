package com.medical.caresync.service;

import com.medical.caresync.dto.CampDiagnosisReportDTO;
import com.medical.caresync.repository.CampDiagnosisReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CampDiagnosisReportService {

    @Autowired
    private CampDiagnosisReportRepository campDiagnosisReportRepository;

    public List<CampDiagnosisReportDTO> getReportByDiagnosis(String diagnosis, Integer campId) {
        return campDiagnosisReportRepository.findByDiagnosis(diagnosis, campId);
    }
}
