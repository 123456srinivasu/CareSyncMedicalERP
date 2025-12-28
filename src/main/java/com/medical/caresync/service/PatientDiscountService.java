package com.medical.caresync.service;

import com.medical.caresync.dto.PatientDiscountDTO;
import com.medical.caresync.entities.PatientDiscount;
import com.medical.caresync.repository.PatientDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientDiscountService {

    @Autowired
    private PatientDiscountRepository patientDiscountRepository;

    public List<PatientDiscountDTO> getAllPatientDiscounts() {
        return patientDiscountRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatientDiscountDTO createPatientDiscount(PatientDiscountDTO patientDiscountDTO) {
        PatientDiscount patientDiscount = convertToEntity(patientDiscountDTO);
        patientDiscount = patientDiscountRepository.save(patientDiscount);
        return convertToDTO(patientDiscount);
    }

    private PatientDiscountDTO convertToDTO(PatientDiscount patientDiscount) {
        PatientDiscountDTO dto = new PatientDiscountDTO();
        dto.setId(patientDiscount.getId());
        return dto;
    }

    private PatientDiscount convertToEntity(PatientDiscountDTO dto) {
        PatientDiscount patientDiscount = new PatientDiscount();
        patientDiscount.setId(dto.getId());
        return patientDiscount;
    }
}
