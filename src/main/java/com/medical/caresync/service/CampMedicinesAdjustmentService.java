package com.medical.caresync.service;

import com.medical.caresync.repository.CampMedicinesAdjustmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.caresync.dto.CampMedicinesAdjustmentDTO;
import com.medical.caresync.entities.CampMedicinesAdjustment;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
public class CampMedicinesAdjustmentService {

    @Autowired
    private CampMedicinesAdjustmentRepository repository;

    @Transactional
    public void saveAll(List<CampMedicinesAdjustmentDTO> dtos) {
        List<CampMedicinesAdjustment> entities = dtos.stream().map(this::convertToEntity).collect(Collectors.toList());
        repository.saveAll(entities);
    }
    public List<CampMedicinesAdjustmentDTO> getByCampDetailsId(Long campDetailsId) {
        return repository.findByCampDetailsId(campDetailsId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private CampMedicinesAdjustment convertToEntity(CampMedicinesAdjustmentDTO dto) {
        CampMedicinesAdjustment entity = new CampMedicinesAdjustment();
        entity.setAdjustmentId(dto.getAdjustmentId());
        entity.setCampDetailsId(dto.getCampDetailsId());
        entity.setMedicineNm(dto.getMedicineNm());
        entity.setManufacturingCompany(dto.getManufacturingCompany());
        entity.setCampEndingQuantity(dto.getCampEndingQuantity());
        entity.setAdjustedQuantity(dto.getAdjustedQuantity());
        entity.setDifference(dto.getDifference());
        return entity;
    }
    private CampMedicinesAdjustmentDTO convertToDTO(CampMedicinesAdjustment entity) {
        CampMedicinesAdjustmentDTO dto = new CampMedicinesAdjustmentDTO();
        dto.setAdjustmentId(entity.getAdjustmentId());
        dto.setCampDetailsId(entity.getCampDetailsId());
        dto.setMedicineNm(entity.getMedicineNm());
        dto.setManufacturingCompany(entity.getManufacturingCompany());
        dto.setCampEndingQuantity(entity.getCampEndingQuantity());
        dto.setAdjustedQuantity(entity.getAdjustedQuantity());
        dto.setDifference(entity.getDifference());
        return dto;
    }
}
