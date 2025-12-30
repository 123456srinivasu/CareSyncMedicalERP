package com.medical.caresync.service;
import com.medical.caresync.dto.CampMedicinesReportSummaryDTO;
public interface CampMedicinesReportService {
    CampMedicinesReportSummaryDTO getReportByMedicineId(Long medicineId);
}