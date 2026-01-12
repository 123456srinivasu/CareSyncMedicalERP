package com.medical.caresync.service;

import com.medical.caresync.entities.DistrictLookup;
import com.medical.caresync.repository.DistrictLookupRepository;
import com.medical.caresync.repository.StateLookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DistrictLookupService {

    private final DistrictLookupRepository districtLookupRepository;
    private final StateLookupRepository stateLookupRepository;

    @Autowired
    public DistrictLookupService(DistrictLookupRepository districtLookupRepository,
            StateLookupRepository stateLookupRepository) {
        this.districtLookupRepository = districtLookupRepository;
        this.stateLookupRepository = stateLookupRepository;
    }

    public DistrictLookup createDistrict(DistrictLookup districtLookup) {
        // Validate state exists if coming from ID only payload, though typically
        // handled by JPA relationships
        return districtLookupRepository.save(districtLookup);
    }

    @Transactional(readOnly = true)
    public List<DistrictLookup> getAllDistricts() {
        return districtLookupRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<DistrictLookup> getDistrictsByStateId(Long stateId) {
        return districtLookupRepository.findByStateLookup_StateLookupId(stateId);
    }

    @Transactional(readOnly = true)
    public Optional<DistrictLookup> getDistrictById(Long id) {
        return districtLookupRepository.findById(id);
    }

    public DistrictLookup updateDistrict(Long id, DistrictLookup districtDetails) {
        return districtLookupRepository.findById(id).map(district -> {
            district.setDistrictName(districtDetails.getDistrictName());
            if (districtDetails.getStateLookup() != null) {
                district.setStateLookup(districtDetails.getStateLookup());
            }
            return districtLookupRepository.save(district);
        }).orElseThrow(() -> new RuntimeException("District not found with id " + id));
    }

    public void deleteDistrict(Long id) {
        districtLookupRepository.deleteById(id);
    }
}
