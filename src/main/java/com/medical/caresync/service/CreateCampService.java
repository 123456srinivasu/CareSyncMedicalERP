package com.medical.caresync.service;

import com.medical.caresync.dto.CreateCampDTO;
import com.medical.caresync.entities.CreateCamp;
import com.medical.caresync.repository.CreateCampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CreateCampService {

    @Autowired
    private CreateCampRepository repository;

    @Transactional
    public CreateCampDTO createCamp(CreateCampDTO dto) {
        CreateCamp entity = mapToEntity(dto);
        entity = repository.save(entity);
        return mapToDTO(entity);
    }

    public List<CreateCampDTO> getAllCamps() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public CreateCampDTO getCampById(Long id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Transactional
    public CreateCampDTO updateCamp(Long id, CreateCampDTO dto) {
        if (repository.existsById(id)) {
            CreateCamp entity = mapToEntity(dto);
            entity.setId(id);
            entity = repository.save(entity);
            return mapToDTO(entity);
        }
        return null;
    }

    public void deleteCamp(Long id) {
        repository.deleteById(id);
    }

    private CreateCamp mapToEntity(CreateCampDTO dto) {
        CreateCamp entity = new CreateCamp();
        entity.setId(dto.getId());
        entity.setCampStartDt(dto.getCampStartDt());
        entity.setNextCampDate(dto.getNextCampDate());
        entity.setCampPerPatientAmount(dto.getCampPerPatientAmount());
        entity.setCampLocation(dto.getCampLocation());
        entity.setOrganiserNm(dto.getOrganiserNm());
        entity.setOrganiserMobileNumber(dto.getOrganiserMobileNumber());
        entity.setAddressLine1(dto.getAddressLine1());
        entity.setStateLookupId(dto.getStateLookupId());
        entity.setDistrictLookupId(dto.getDistrictLookupId());
        entity.setMandalLookupId(dto.getMandalLookupId());
        entity.setCity(dto.getCity());
        entity.setZipCd(dto.getZipCd());
        
        if (dto.getBlocks() != null) {
            List<CreateCamp.CreateCampBlock> blocks = new ArrayList<>();
            for (CreateCampDTO.CreateCampBlockDTO blockDTO : dto.getBlocks()) {
                CreateCamp.CreateCampBlock block = new CreateCamp.CreateCampBlock();
                block.setId(blockDTO.getId());
                block.setBlockName(blockDTO.getBlockName());
                blocks.add(block);
            }
            entity.setBlocks(blocks);
        }
        
        return entity;
    }

    private CreateCampDTO mapToDTO(CreateCamp entity) {
        CreateCampDTO dto = new CreateCampDTO();
        dto.setId(entity.getId());
        dto.setCampStartDt(entity.getCampStartDt());
        dto.setNextCampDate(entity.getNextCampDate());
        dto.setCampPerPatientAmount(entity.getCampPerPatientAmount());
        dto.setCampLocation(entity.getCampLocation());
        dto.setOrganiserNm(entity.getOrganiserNm());
        dto.setOrganiserMobileNumber(entity.getOrganiserMobileNumber());
        dto.setAddressLine1(entity.getAddressLine1());
        dto.setStateLookupId(entity.getStateLookupId());
        dto.setDistrictLookupId(entity.getDistrictLookupId());
        dto.setMandalLookupId(entity.getMandalLookupId());
        dto.setCity(entity.getCity());
        dto.setZipCd(entity.getZipCd());
        if (entity.getBlocks() != null) {
            List<CreateCampDTO.CreateCampBlockDTO> blockDTOs = new ArrayList<>();
            for (CreateCamp.CreateCampBlock block : entity.getBlocks()) {
                CreateCampDTO.CreateCampBlockDTO blockDTO = new CreateCampDTO.CreateCampBlockDTO();
                blockDTO.setId(block.getId());
                blockDTO.setBlockName(block.getBlockName());
                blockDTOs.add(blockDTO);
            }
            dto.setBlocks(blockDTOs);
        }
        return dto;
    }
}
