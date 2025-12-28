package com.medical.caresync.service;

import com.medical.caresync.dto.BloodCampDTO;
import com.medical.caresync.entities.BloodCamp;
import com.medical.caresync.repository.BloodCampRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BloodCampService {

    @Autowired
    private BloodCampRepository bloodCampRepository;

    public BloodCampDTO registerPatient(BloodCampDTO dto) {
        BloodCamp entity = new BloodCamp();
        BeanUtils.copyProperties(dto, entity);
        
        entity.setCreationUserId("SYSTEM"); // Example default
        entity.setCreationTs(new Timestamp(System.currentTimeMillis()));
        
        BloodCamp saved = bloodCampRepository.save(entity);
        BeanUtils.copyProperties(saved, dto);
        return dto;
    }

    public Page<BloodCampDTO> getPatientsByCamp(Integer campId, Pageable pageable) {
        return bloodCampRepository.findByCampId(campId, pageable).map(entity -> {
            BloodCampDTO dto = new BloodCampDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        });
    }
}