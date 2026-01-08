package com.medical.caresync.service;

import com.medical.caresync.entities.CampUsers;
import com.medical.caresync.repository.CampUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CampUsersService {

    private final CampUsersRepository repository;

    @Autowired
    public CampUsersService(CampUsersRepository repository) {
        this.repository = repository;
    }

    public CampUsers createCampUser(CampUsers campUser) {
        return repository.save(campUser);
    }

    @Transactional(readOnly = true)
    public List<CampUsers> getAllCampUsers() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<CampUsers> getCampUsersByCampId(Long campId) {
        return repository.findByCamps_CampId(campId);
    }

    @Transactional(readOnly = true)
    public Optional<CampUsers> getCampUserById(Long id) {
        return repository.findById(id);
    }

    public CampUsers updateCampUser(Long id, CampUsers details) {
        return repository.findById(id).map(existing -> {
            existing.setLocation(details.getLocation());
            existing.setUpdatedBy(details.getUpdatedBy());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("CampUser not found with id " + id));
    }

    public void deleteCampUser(Long id) {
        repository.deleteById(id);
    }
}
