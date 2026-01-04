package com.medical.caresync.service;

import com.medical.caresync.entities.CampMedicineStockSummary;
import com.medical.caresync.repository.CampMedicineStockSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CampMedicineStockSummaryService {

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
}

