package com.medical.caresync.service;

import com.medical.caresync.dto.CampMedicinesReportDTO;
import com.medical.caresync.dto.CampMedicinesReportSummaryDTO;
import com.medical.caresync.repository.CampMedicinesReportRepository;
import com.medical.caresync.service.CampMedicinesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional(readOnly = true)
public class CampMedicinesReportServiceImpl implements CampMedicinesReportService {
    private final CampMedicinesReportRepository campMedicinesReportRepository;
    @Autowired
    public CampMedicinesReportServiceImpl(CampMedicinesReportRepository campMedicinesReportRepository) {
        this.campMedicinesReportRepository = campMedicinesReportRepository;
    }
    @Override
    public CampMedicinesReportSummaryDTO getReportByMedicineId(Long medicineId) {
        List<CampMedicinesReportDTO> patientMedications =
                campMedicinesReportRepository.findByMedicineId(medicineId);

        Integer totalPatients =
                campMedicinesReportRepository.countDistinctPatientsByMedicineId(medicineId);

        Integer totalMedicines =
                campMedicinesReportRepository.sumQuantityIssuedByMedicineId(medicineId);
        return new CampMedicinesReportSummaryDTO(totalPatients, totalMedicines, patientMedications);
    }
}

