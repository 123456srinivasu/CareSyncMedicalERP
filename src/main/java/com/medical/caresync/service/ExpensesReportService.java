package com.medical.caresync.service;

import com.medical.caresync.dto.ExpensesReportDTO;
import com.medical.caresync.entities.ExpensesReport;
import com.medical.caresync.repository.ExpensesReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpensesReportService {

    @Autowired
    private ExpensesReportRepository expensesReportRepository;

    public List<ExpensesReportDTO> getAllExpensesReports() {
        return expensesReportRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ExpensesReportDTO createExpensesReport(ExpensesReportDTO expensesReportDTO) {
        ExpensesReport expensesReport = convertToEntity(expensesReportDTO);
        expensesReport = expensesReportRepository.save(expensesReport);
        return convertToDTO(expensesReport);
    }

    private ExpensesReportDTO convertToDTO(ExpensesReport expensesReport) {
        ExpensesReportDTO dto = new ExpensesReportDTO();
        dto.setId(expensesReport.getId());
        return dto;
    }

    private ExpensesReport convertToEntity(ExpensesReportDTO dto) {
        ExpensesReport expensesReport = new ExpensesReport();
        expensesReport.setId(dto.getId());
        return expensesReport;
    }
}
