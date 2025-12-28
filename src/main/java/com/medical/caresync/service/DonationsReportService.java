package com.medical.caresync.service;

import com.medical.caresync.dto.DonationsReportDTO;
import com.medical.caresync.entities.DonationsReport;
import com.medical.caresync.repository.DonationsReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationsReportService {

    @Autowired
    private DonationsReportRepository donationsReportRepository;

    public List<DonationsReportDTO> getAllDonationsReports() {
        return donationsReportRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DonationsReportDTO createDonationsReport(DonationsReportDTO donationsReportDTO) {
        DonationsReport donationsReport = convertToEntity(donationsReportDTO);
        donationsReport = donationsReportRepository.save(donationsReport);
        return convertToDTO(donationsReport);
    }

    private DonationsReportDTO convertToDTO(DonationsReport donationsReport) {
        DonationsReportDTO dto = new DonationsReportDTO();
        dto.setId(donationsReport.getId());
        return dto;
    }

    private DonationsReport convertToEntity(DonationsReportDTO dto) {
        DonationsReport donationsReport = new DonationsReport();
        donationsReport.setId(dto.getId());
        return donationsReport;
    }
}
