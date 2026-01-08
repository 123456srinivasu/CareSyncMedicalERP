package com.medical.caresync.service;

import com.medical.caresync.entities.CampPlans;
import com.medical.caresync.repository.CampPlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CampPlansService {

    private final CampPlansRepository repository;

    @Autowired
    public CampPlansService(CampPlansRepository repository) {
        this.repository = repository;
    }

    public CampPlans createPlan(CampPlans plan) {
        return repository.save(plan);
    }

    @Transactional(readOnly = true)
    public List<CampPlans> getAllPlans() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<CampPlans> getPlansByCampId(Long campId) {
        return repository.findByCamps_CampId(campId);
    }

    @Transactional(readOnly = true)
    public Optional<CampPlans> getPlanById(Long id) {
        return repository.findById(id);
    }

    public CampPlans updatePlan(Long id, CampPlans details) {
        return repository.findById(id).map(existing -> {
            existing.setPlannedDate(details.getPlannedDate());
            existing.setIsActive(details.getIsActive());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Pro Plan not found with id " + id));
    }

    public void deletePlan(Long id) {
        repository.deleteById(id);
    }
}
