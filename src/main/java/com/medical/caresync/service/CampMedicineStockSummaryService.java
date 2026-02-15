package com.medical.caresync.service;

import com.medical.caresync.dto.CampMedicineStockSummaryResponseDTO;
import com.medical.caresync.entities.CampMedicineStockSummary;
import com.medical.caresync.entities.MedicineLookupNew;
import com.medical.caresync.repository.CampMedicineStockSummaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CampMedicineStockSummaryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampMedicineStockSummaryService.class);

    @Autowired
    private CampMedicineStockSummaryRepository repository;

    public List<CampMedicineStockSummary> getAllSummaries() {
        return repository.findAll();
    }

    public Optional<CampMedicineStockSummary> getSummaryById(Long id) {
        return repository.findById(id);
    }

    public List<CampMedicineStockSummary> getSummariesByCampId(Long campId) {
        return repository.findByCamps_CampId(campId);
    }

    public List<CampMedicineStockSummaryResponseDTO> getMedicinesByCampId(Long campId) {
        LOGGER.info("Fetching medicines for camp ID: {}", campId);
        
        List<CampMedicineStockSummary> summaries = repository.findByCamps_CampId(campId);
        
        return summaries.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private CampMedicineStockSummaryResponseDTO mapToResponseDTO(CampMedicineStockSummary summary) {
        MedicineLookupNew medicine = summary.getMedicineLookupNew();
        
        return new CampMedicineStockSummaryResponseDTO(
                summary.getCampMedicineStockSummaryId(),
                summary.getCamps() != null ? summary.getCamps().getCampId() : null,
                medicine != null ? medicine.getMedicationId() : null,
                medicine != null ? medicine.getMedicationName() : null,
                medicine != null ? medicine.getMedicationCode() : null,
                medicine != null ? medicine.getMedicineType() : null,
                summary.getQuantity()
        );
    }
}

