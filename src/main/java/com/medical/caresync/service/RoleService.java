package com.medical.caresync.service;

import com.medical.caresync.entities.Role;
import com.medical.caresync.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role createRole(Role role) {
        return repository.save(role);
    }

    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Role> getRoleById(Integer id) {
        return repository.findById(id);
    }

    public void deleteRole(Integer id) {
        repository.deleteById(id);
    }
}
