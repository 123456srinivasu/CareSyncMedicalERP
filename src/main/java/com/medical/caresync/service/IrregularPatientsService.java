package com.medical.caresync.service;

import com.medical.caresync.dto.IrregularPatientsDTO;
import com.medical.caresync.entities.IrregularPatients;
import com.medical.caresync.repository.IrregularPatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IrregularPatientsService {

    @Autowired
    private IrregularPatientsRepository irregularPatientsRepository;

    public List<IrregularPatientsDTO> getAllIrregularPatients() {
        return irregularPatientsRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public IrregularPatientsDTO createIrregularPatients(IrregularPatientsDTO irregularPatientsDTO) {
        IrregularPatients irregularPatients = convertToEntity(irregularPatientsDTO);
        irregularPatients = irregularPatientsRepository.save(irregularPatients);
        return convertToDTO(irregularPatients);
    }

    private IrregularPatientsDTO convertToDTO(IrregularPatients irregularPatients) {
        IrregularPatientsDTO dto = new IrregularPatientsDTO();
        dto.setId(irregularPatients.getId());
        return dto;
    }

    private IrregularPatients convertToEntity(IrregularPatientsDTO dto) {
        IrregularPatients irregularPatients = new IrregularPatients();
        irregularPatients.setId(dto.getId());
        return irregularPatients;
    }
}
