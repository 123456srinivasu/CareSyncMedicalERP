package com.medical.caresync.service;

import com.medical.caresync.dto.ImportDataDTO;
import com.medical.caresync.entities.ImportData;
import com.medical.caresync.repository.ImportDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImportDataService {

    @Autowired
    private ImportDataRepository importDataRepository;

    public List<ImportDataDTO> getAllImportData() {
        return importDataRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ImportDataDTO createImportData(ImportDataDTO importDataDTO) {
        ImportData importData = convertToEntity(importDataDTO);
        importData = importDataRepository.save(importData);
        return convertToDTO(importData);
    }

    private ImportDataDTO convertToDTO(ImportData importData) {
        ImportDataDTO dto = new ImportDataDTO();
        dto.setId(importData.getId());
        return dto;
    }

    private ImportData convertToEntity(ImportDataDTO dto) {
        ImportData importData = new ImportData();
        importData.setId(dto.getId());
        return importData;
    }
}
