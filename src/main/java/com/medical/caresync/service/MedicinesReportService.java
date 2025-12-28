package com.medical.caresync.service;

import com.medical.caresync.dto.MedicinesReportDTO;
import com.medical.caresync.entities.MedicinesReport;
import com.medical.caresync.repository.MedicinesReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicinesReportService {

    @Autowired
    private MedicinesReportRepository medicinesReportRepository;

    public List<MedicinesReportDTO> getAllMedicinesReports() {
        return medicinesReportRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public MedicinesReportDTO createMedicinesReport(MedicinesReportDTO medicinesReportDTO) {
        MedicinesReport medicinesReport = convertToEntity(medicinesReportDTO);
        medicinesReport = medicinesReportRepository.save(medicinesReport);
        return convertToDTO(medicinesReport);
    }

    private MedicinesReportDTO convertToDTO(MedicinesReport medicinesReport) {
        MedicinesReportDTO dto = new MedicinesReportDTO();
        dto.setId(medicinesReport.getId());
        return dto;
    }

    private MedicinesReport convertToEntity(MedicinesReportDTO dto) {
        MedicinesReport medicinesReport = new MedicinesReport();
        medicinesReport.setId(dto.getId());
        return medicinesReport;
    }
}
