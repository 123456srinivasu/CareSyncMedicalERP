package com.medical.caresync.service;

import com.medical.caresync.entities.MandalLookup;
import com.medical.caresync.repository.MandalLookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MandalLookupService {

    private final MandalLookupRepository mandalLookupRepository;

    @Autowired
    public MandalLookupService(MandalLookupRepository mandalLookupRepository) {
        this.mandalLookupRepository = mandalLookupRepository;
    }

    public MandalLookup createMandal(MandalLookup mandalLookup) {
        return mandalLookupRepository.save(mandalLookup);
    }

    @Transactional(readOnly = true)
    public List<MandalLookup> getAllMandals() {
        return mandalLookupRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<MandalLookup> getMandalsByDistrictId(Integer districtId) {
        return mandalLookupRepository.findByDistrictLookup_DistrictLookupId(districtId);
    }

    @Transactional(readOnly = true)
    public Optional<MandalLookup> getMandalById(Integer id) {
        return mandalLookupRepository.findById(id);
    }

    public MandalLookup updateMandal(Integer id, MandalLookup mandalDetails) {
        return mandalLookupRepository.findById(id).map(mandal -> {
            mandal.setMandalName(mandalDetails.getMandalName());
            if (mandalDetails.getDistrictLookup() != null) {
                mandal.setDistrictLookup(mandalDetails.getDistrictLookup());
            }
            return mandalLookupRepository.save(mandal);
        }).orElseThrow(() -> new RuntimeException("Mandal not found with id " + id));
    }

    public void deleteMandal(Integer id) {
        mandalLookupRepository.deleteById(id);
    }
}
