package com.medical.caresync.service;

import com.medical.caresync.dto.ManageLabsDTO;
import com.medical.caresync.entities.ManageLabs;
import com.medical.caresync.repository.ManageLabsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManageLabsService {

    @Autowired
    private ManageLabsRepository manageLabsRepository;

    public List<ManageLabsDTO> getAllManageLabs() {
        return manageLabsRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ManageLabsDTO createManageLabs(ManageLabsDTO manageLabsDTO) {
        ManageLabs manageLabs = convertToEntity(manageLabsDTO);
        manageLabs = manageLabsRepository.save(manageLabs);
        return convertToDTO(manageLabs);
    }

    private ManageLabsDTO convertToDTO(ManageLabs manageLabs) {
        ManageLabsDTO dto = new ManageLabsDTO();
        dto.setId(manageLabs.getId());
        return dto;
    }

    private ManageLabs convertToEntity(ManageLabsDTO dto) {
        ManageLabs manageLabs = new ManageLabs();
        manageLabs.setId(dto.getId());
        return manageLabs;
    }
}
