package com.medical.caresync.service;

import com.medical.caresync.dto.WarehouseMasterDTO;
import com.medical.caresync.entities.DistrictLookup;
import com.medical.caresync.entities.MandalLookup;
import com.medical.caresync.entities.StateLookup;
import com.medical.caresync.entities.WarehouseMaster;
import com.medical.caresync.repository.DistrictLookupRepository;
import com.medical.caresync.repository.MandalLookupRepository;
import com.medical.caresync.repository.StateLookupRepository;
import com.medical.caresync.repository.WarehouseMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseMasterService {

    @Autowired
    private WarehouseMasterRepository repository;

    @Autowired
    private StateLookupRepository stateRepository;

    @Autowired
    private DistrictLookupRepository districtRepository;

    @Autowired
    private MandalLookupRepository mandalRepository;

    public List<WarehouseMasterDTO> getAllWarehouses() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public WarehouseMasterDTO getWarehouseById(Long id) {
        return repository.findById(id).map(this::convertToDTO).orElse(null);
    }

    @Transactional
    public WarehouseMasterDTO createWarehouse(WarehouseMasterDTO dto) {
        WarehouseMaster warehouse = new WarehouseMaster();
        mapDtoToEntity(dto, warehouse);
        warehouse.setCreatedAt(LocalDateTime.now());
        warehouse.setCreatedBy("ADMIN"); // Mocked for simplicity, use SecurityContext in real app
        warehouse = repository.save(warehouse);
        return convertToDTO(warehouse);
    }

    @Transactional
    public WarehouseMasterDTO updateWarehouse(Long id, WarehouseMasterDTO dto) {
        return repository.findById(id).map(warehouse -> {
            mapDtoToEntity(dto, warehouse);
            warehouse.setUpdatedAt(LocalDateTime.now());
            warehouse.setUpdatedBy("ADMIN");
            warehouse = repository.save(warehouse);
            return convertToDTO(warehouse);
        }).orElse(null);
    }

    @Transactional
    public void deleteWarehouse(Long id) {
        repository.findById(id).ifPresent(warehouse -> {
            warehouse.setIsActive(false); // Soft Delete
            repository.save(warehouse);
        });
    }

    private WarehouseMasterDTO convertToDTO(WarehouseMaster entity) {
        if (entity == null) return null;
        WarehouseMasterDTO dto = new WarehouseMasterDTO();
        dto.setId(entity.getId());
        dto.setWarehouseCode(entity.getWarehouseCode());
        dto.setWarehouseName(entity.getWarehouseName());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setPostalCode(entity.getPostalCode());
        
        if (entity.getState() != null) {
            dto.setStateId((long) entity.getState().getStateLookupId());
            dto.setStateName(entity.getState().getStateName());
        }
        if (entity.getDistrict() != null) {
            dto.setDistrictId((long) entity.getDistrict().getDistrictLookupId());
            dto.setDistrictName(entity.getDistrict().getDistrictName());
        }
        if (entity.getMandal() != null) {
            dto.setMandalId((long) entity.getMandal().getMandalLookupId());
            dto.setMandalName(entity.getMandal().getMandalName());
        }
        
        dto.setContactPerson(entity.getContactPerson());
        dto.setContactNumber(entity.getContactNumber());
        dto.setEmailAddress(entity.getEmailAddress());
        dto.setIsActive(entity.getIsActive());
        
        return dto;
    }

    private void mapDtoToEntity(WarehouseMasterDTO dto, WarehouseMaster entity) {
        entity.setWarehouseCode(dto.getWarehouseCode());
        entity.setWarehouseName(dto.getWarehouseName());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setPostalCode(dto.getPostalCode());
        
        if (dto.getStateId() != null) {
            StateLookup state = stateRepository.findById(dto.getStateId().intValue()).orElse(null);
            entity.setState(state);
        } else {
            entity.setState(null);
        }
        
        if (dto.getDistrictId() != null) {
            DistrictLookup district = districtRepository.findById(dto.getDistrictId().intValue()).orElse(null);
            entity.setDistrict(district);
        } else {
            entity.setDistrict(null);
        }
        
        if (dto.getMandalId() != null) {
            MandalLookup mandal = mandalRepository.findById(dto.getMandalId().intValue()).orElse(null);
            entity.setMandal(mandal);
        } else {
            entity.setMandal(null);
        }
        
        entity.setContactPerson(dto.getContactPerson());
        entity.setContactNumber(dto.getContactNumber());
        entity.setEmailAddress(dto.getEmailAddress());
        
        if(dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }
    }
}
