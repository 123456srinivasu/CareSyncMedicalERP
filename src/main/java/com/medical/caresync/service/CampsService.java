package com.medical.caresync.service;

import com.medical.caresync.entities.Camps;
import com.medical.caresync.repository.CampsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CampsService {

    @Autowired
    private CampsRepository repository;

    public List<Camps> getAllCamps() {
        return repository.findAll();
    }

    public Optional<Camps> getCampById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Camps createCamp(Camps camp) {
        // Set defaults
        if (camp.getIsActive() == null) {
            camp.setIsActive(true);
        }
        if (camp.getCreatedAt() == null) {
            camp.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }
        if (camp.getUpdateAt() == null) {
            camp.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        }
        return repository.save(camp);
    }

    @Transactional
    public Camps updateCamp(Long id, Camps campDetails) {
        Optional<Camps> optionalCamp = repository.findById(id);
        if (optionalCamp.isPresent()) {
            Camps camp = optionalCamp.get();
            camp.setCampName(campDetails.getCampName());
            camp.setDescription(campDetails.getDescription());
            camp.setIsActive(campDetails.getIsActive());
            camp.setCampEstablishmentYear(campDetails.getCampEstablishmentYear());
            camp.setCampCode(campDetails.getCampCode());
            camp.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            camp.setUpdatedBy(campDetails.getUpdatedBy());
            return repository.save(camp);
        }
        return null;
    }

    @Transactional
    public void deleteCamp(Long id) {
        repository.deleteById(id);
    }

    public List<Camps> getActiveCamps() {
        return repository.findAll().stream()
                .filter(camp -> Boolean.TRUE.equals(camp.getIsActive()))
                .toList();
    }
}

