package com.medical.caresync.service;

import com.medical.caresync.dto.IncomeExpenseReportDTO;
import com.medical.caresync.entities.IncomeExpenseReport;
import com.medical.caresync.repository.IncomeExpenseReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomeExpenseReportService {

    @Autowired
    private IncomeExpenseReportRepository incomeExpenseReportRepository;

    public List<IncomeExpenseReportDTO> getAllIncomeExpenseReports() {
        return incomeExpenseReportRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public IncomeExpenseReportDTO createIncomeExpenseReport(IncomeExpenseReportDTO incomeExpenseReportDTO) {
        IncomeExpenseReport incomeExpenseReport = convertToEntity(incomeExpenseReportDTO);
        incomeExpenseReport = incomeExpenseReportRepository.save(incomeExpenseReport);
        return convertToDTO(incomeExpenseReport);
    }

    private IncomeExpenseReportDTO convertToDTO(IncomeExpenseReport incomeExpenseReport) {
        IncomeExpenseReportDTO dto = new IncomeExpenseReportDTO();
        dto.setId(incomeExpenseReport.getId());
        return dto;
    }

    private IncomeExpenseReport convertToEntity(IncomeExpenseReportDTO dto) {
        IncomeExpenseReport incomeExpenseReport = new IncomeExpenseReport();
        incomeExpenseReport.setId(dto.getId());
        return incomeExpenseReport;
    }
}
