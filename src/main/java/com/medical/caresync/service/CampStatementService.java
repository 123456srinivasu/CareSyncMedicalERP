package com.medical.caresync.service;

import com.medical.caresync.dto.CampStatementDTO;
import com.medical.caresync.entities.CampStatement;
import com.medical.caresync.repository.CampStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampStatementService {

    @Autowired
    private CampStatementRepository campStatementRepository;

    public List<CampStatementDTO> getAllCampStatements() {
        return campStatementRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CampStatementDTO createCampStatement(CampStatementDTO campStatementDTO) {
        CampStatement campStatement = convertToEntity(campStatementDTO);
        campStatement = campStatementRepository.save(campStatement);
        return convertToDTO(campStatement);
    }

    private CampStatementDTO convertToDTO(CampStatement campStatement) {
        CampStatementDTO dto = new CampStatementDTO();
        dto.setId(campStatement.getId());
        return dto;
    }

    private CampStatement convertToEntity(CampStatementDTO dto) {
        CampStatement campStatement = new CampStatement();
        campStatement.setId(dto.getId());
        return campStatement;
    }
}
