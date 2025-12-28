package com.medical.caresync.service;

import com.medical.caresync.dto.GreenChannelConsultationDTO;
import com.medical.caresync.entities.GreenChannelConsultation;
import com.medical.caresync.repository.GreenChannelConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GreenChannelConsultationService {

    @Autowired
    private GreenChannelConsultationRepository greenChannelConsultationRepository;

    public List<GreenChannelConsultationDTO> getAllGreenChannelConsultations() {
        return greenChannelConsultationRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public GreenChannelConsultationDTO createGreenChannelConsultation(GreenChannelConsultationDTO greenChannelConsultationDTO) {
        GreenChannelConsultation greenChannelConsultation = convertToEntity(greenChannelConsultationDTO);
        greenChannelConsultation = greenChannelConsultationRepository.save(greenChannelConsultation);
        return convertToDTO(greenChannelConsultation);
    }

    private GreenChannelConsultationDTO convertToDTO(GreenChannelConsultation greenChannelConsultation) {
        GreenChannelConsultationDTO dto = new GreenChannelConsultationDTO();
        dto.setId(greenChannelConsultation.getId());
        return dto;
    }

    private GreenChannelConsultation convertToEntity(GreenChannelConsultationDTO dto) {
        GreenChannelConsultation greenChannelConsultation = new GreenChannelConsultation();
        greenChannelConsultation.setId(dto.getId());
        return greenChannelConsultation;
    }
}
