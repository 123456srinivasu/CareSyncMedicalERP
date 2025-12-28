package com.medical.caresync.service;

import com.medical.caresync.dto.DeniedDTO;
import com.medical.caresync.entities.Denied;
import com.medical.caresync.repository.DeniedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeniedService {

    @Autowired
    private DeniedRepository deniedRepository;

    public List<DeniedDTO> getAllDenied() {
        return deniedRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DeniedDTO createDenied(DeniedDTO deniedDTO) {
        Denied denied = convertToEntity(deniedDTO);
        denied = deniedRepository.save(denied);
        return convertToDTO(denied);
    }

    private DeniedDTO convertToDTO(Denied denied) {
        DeniedDTO dto = new DeniedDTO();
        dto.setId(denied.getId());
        return dto;
    }

    private Denied convertToEntity(DeniedDTO dto) {
        Denied denied = new Denied();
        denied.setId(dto.getId());
        return denied;
    }
}
