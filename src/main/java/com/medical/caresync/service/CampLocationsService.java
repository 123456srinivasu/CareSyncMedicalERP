package com.medical.caresync.service;

import com.medical.caresync.entities.CampLocations;
import com.medical.caresync.repository.CampLocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CampLocationsService {

    private final CampLocationsRepository repository;

    @Autowired
    public CampLocationsService(CampLocationsRepository repository) {
        this.repository = repository;
    }

    public CampLocations createLocation(CampLocations location) {
        return repository.save(location);
    }

    @Transactional(readOnly = true)
    public List<CampLocations> getAllLocations() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<CampLocations> getLocationsByCampId(Long campId) {
        return repository.findByCamps_CampId(campId);
    }

    @Transactional(readOnly = true)
    public Optional<CampLocations> getLocationById(Long id) {
        return repository.findById(id);
    }

    public CampLocations updateLocation(Long id, CampLocations details) {
        return repository.findById(id).map(existing -> {
            existing.setCreatedBy(details.getCreatedBy());
            // Update other fields as necessary, usually created_at implies immutable but
            // updated_by is missing in schema for locations
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Location not found with id " + id));
    }

    public void deleteLocation(Long id) {
        repository.deleteById(id);
    }
}
