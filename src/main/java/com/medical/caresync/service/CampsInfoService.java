package com.medical.caresync.service;

import com.medical.caresync.dto.CampsInfoDTO;
import com.medical.caresync.entities.CampsInfo;
import com.medical.caresync.repository.CampsInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CampsInfoService {

    @Autowired
    private CampsInfoRepository repository;

    public List<CampsInfoDTO> getAllCampsInfo() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<CampsInfoDTO> getCampsInfoById(Long id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    public CampsInfoDTO saveCampsInfo(CampsInfoDTO dto) {
        CampsInfo entity = convertToEntity(dto);
        CampsInfo savedEntity = repository.save(entity);
        return convertToDTO(savedEntity);
    }

    public void deleteCampsInfo(Long id) {
        repository.deleteById(id);
    }

    private CampsInfoDTO convertToDTO(CampsInfo entity) {
        CampsInfoDTO dto = new CampsInfoDTO();
        dto.setTblCampId(entity.getTblCampId());
        dto.setCampNm(entity.getCampNm());
        dto.setCampEstablishmentDt(entity.getCampEstablishmentDt());
        dto.setOrganizerNm(entity.getOrganizerNm());
        dto.setMobileNumber(entity.getMobileNumber());
        dto.setLocation(entity.getLocation());
        dto.setJanuary(entity.getJanuary());
        dto.setFebruary(entity.getFebruary());
        dto.setMarch(entity.getMarch());
        dto.setApril(entity.getApril());
        dto.setMay(entity.getMay());
        dto.setJune(entity.getJune());
        dto.setJuly(entity.getJuly());
        dto.setAugust(entity.getAugust());
        dto.setSeptember(entity.getSeptember());
        dto.setOctober(entity.getOctober());
        dto.setNovember(entity.getNovember());
        dto.setDecember(entity.getDecember());
        dto.setConductedWeek(entity.getConductedWeek());
        dto.setConductedDay(entity.getConductedDay());
        return dto;
    }

    private CampsInfo convertToEntity(CampsInfoDTO dto) {
        CampsInfo entity = new CampsInfo();
        entity.setTblCampId(dto.getTblCampId());
        entity.setCampNm(dto.getCampNm());
        entity.setCampEstablishmentDt(dto.getCampEstablishmentDt());
        entity.setOrganizerNm(dto.getOrganizerNm());
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setLocation(dto.getLocation());
        entity.setJanuary(dto.getJanuary());
        entity.setFebruary(dto.getFebruary());
        entity.setMarch(dto.getMarch());
        entity.setApril(dto.getApril());
        entity.setMay(dto.getMay());
        entity.setJune(dto.getJune());
        entity.setJuly(dto.getJuly());
        entity.setAugust(dto.getAugust());
        entity.setSeptember(dto.getSeptember());
        entity.setOctober(dto.getOctober());
        entity.setNovember(dto.getNovember());
        entity.setDecember(dto.getDecember());
        entity.setConductedWeek(dto.getConductedWeek());
        entity.setConductedDay(dto.getConductedDay());
        return entity;
    }
}
