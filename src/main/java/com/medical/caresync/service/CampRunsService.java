package com.medical.caresync.service;

import com.medical.caresync.entities.CampRuns;
import com.medical.caresync.repository.CampRunsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CampRunsService {

    private final CampRunsRepository repository;

    @Autowired
    public CampRunsService(CampRunsRepository repository) {
        this.repository = repository;
    }

    public CampRuns createRun(CampRuns run) {
        return repository.save(run);
    }

    @Transactional(readOnly = true)
    public List<CampRuns> getAllRuns() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<CampRuns> getRunsByCampId(Long campId) {
        return repository.findByCamps_CampId(campId);
    }

    @Transactional(readOnly = true)
    public Optional<CampRuns> getRunById(Long id) {
        return repository.findById(id);
    }

    public CampRuns updateRun(Long id, CampRuns details) {
        return repository.findById(id).map(existing -> {
            existing.setActualDate(details.getActualDate());
            existing.setStatus(details.getStatus());
            existing.setStartedBy(details.getStartedBy());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Run not found with id " + id));
    }

    public void deleteRun(Long id) {
        repository.deleteById(id);
    }
}
