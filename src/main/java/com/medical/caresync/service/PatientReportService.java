package com.medical.caresync.service;

import com.medical.caresync.dto.PatientReportDTO;
import com.medical.caresync.entities.PatientReport;
import com.medical.caresync.repository.PatientReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientReportService {

    @Autowired
    private PatientReportRepository patientReportRepository;

    public List<PatientReportDTO> getAllPatientReports() {
        return patientReportRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientReportDTO createPatientReport(PatientReportDTO patientReportDTO) {
        PatientReport patientReport = convertToEntity(patientReportDTO);
        patientReport = patientReportRepository.save(patientReport);
        return convertToDTO(patientReport);
    }

    private PatientReportDTO convertToDTO(PatientReport patientReport) {
        PatientReportDTO dto = new PatientReportDTO();
        dto.setId(patientReport.getId());
        return dto;
    }

    private PatientReport convertToEntity(PatientReportDTO dto) {
        PatientReport patientReport = new PatientReport();
        patientReport.setId(dto.getId());
        return patientReport;
    }
}
