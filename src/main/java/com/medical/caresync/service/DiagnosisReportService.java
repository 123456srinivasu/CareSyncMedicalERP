package com.medical.caresync.service;

import com.medical.caresync.dto.DiagnosisReportDTO;
import com.medical.caresync.entities.DiagnosisReport;
import com.medical.caresync.repository.DiagnosisReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiagnosisReportService {

    @Autowired
    private DiagnosisReportRepository diagnosisReportRepository;

    public List<DiagnosisReportDTO> getAllDiagnosisReports() {
        return diagnosisReportRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DiagnosisReportDTO createDiagnosisReport(DiagnosisReportDTO diagnosisReportDTO) {
        DiagnosisReport diagnosisReport = convertToEntity(diagnosisReportDTO);
        diagnosisReport = diagnosisReportRepository.save(diagnosisReport);
        return convertToDTO(diagnosisReport);
    }

    private DiagnosisReportDTO convertToDTO(DiagnosisReport diagnosisReport) {
        DiagnosisReportDTO dto = new DiagnosisReportDTO();
        dto.setId(diagnosisReport.getId());
        return dto;
    }

    private DiagnosisReport convertToEntity(DiagnosisReportDTO dto) {
        DiagnosisReport diagnosisReport = new DiagnosisReport();
        diagnosisReport.setId(dto.getId());
        return diagnosisReport;
    }
}
