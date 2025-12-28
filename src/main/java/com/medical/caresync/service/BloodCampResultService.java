package com.medical.caresync.service;

import com.medical.caresync.dto.BloodCampResultDTO;
import com.medical.caresync.entities.BloodCampResult;
import com.medical.caresync.repository.BloodCampResultRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BloodCampResultService {

    @Autowired
    private BloodCampResultRepository repository;

    public Page<BloodCampResultDTO> getAllResults(Pageable pageable) {
        return repository.findAll(pageable).map(this::convertToDTO);
    }

    public Page<BloodCampResultDTO> getResultsByCampId(Integer campId, Pageable pageable) {
        return repository.findByCampId(campId, pageable).map(this::convertToDTO);
    }

    public BloodCampResultDTO getResultById(Integer id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public BloodCampResultDTO saveResult(BloodCampResultDTO dto) {
        BloodCampResult entity = new BloodCampResult();
        BeanUtils.copyProperties(dto, entity);
        BloodCampResult saved = repository.save(entity);
        return convertToDTO(saved);
    }

    public BloodCampResultDTO updateResult(Integer id, BloodCampResultDTO dto) {
        return repository.findById(id).map(entity -> {
            BeanUtils.copyProperties(dto, entity, "id");
            BloodCampResult updated = repository.save(entity);
            return convertToDTO(updated);
        }).orElse(null);
    }

    private BloodCampResultDTO convertToDTO(BloodCampResult entity) {
        BloodCampResultDTO dto = new BloodCampResultDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}