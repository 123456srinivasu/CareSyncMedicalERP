package com.medical.caresync.service;

import com.medical.caresync.entities.Users;
import com.medical.caresync.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUsers(Users users) {
        return usersRepository.save(users);
    }

    @Transactional(readOnly = true)
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Users> getUsersById(Long id) {
        return usersRepository.findById(id);
    }

    public Users updateUsers(Long id, Users usersDetails) {
        return usersRepository.findById(id).map(users -> {
            users.setUserName(usersDetails.getUserName());
            users.setPhone(usersDetails.getPhone());
            users.setEmail(usersDetails.getEmail());
            users.setLoginId(usersDetails.getLoginId());
            users.setPassword(usersDetails.getPassword());
            users.setIsActive(usersDetails.getIsActive());
            users.setIsTemporary(usersDetails.getIsTemporary());
            users.setCreatedBy(usersDetails.getCreatedBy());
            users.setUpdatedBy(usersDetails.getUpdatedBy());
            return usersRepository.save(users);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public void deleteUsers(Long id) {
        usersRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Users> getActiveUsers() {
        return usersRepository.findByIsActive(true);
    }

    @Transactional(readOnly = true)
    public List<Users> getUsersByRoleName(String roleName) {
        return usersRepository.findByRole_RoleName(roleName);
    }

    @Transactional(readOnly = true)
    public List<Users> getUsersByRoleId(Integer roleId) {
        return usersRepository.findByRole_RoleId(roleId);
    }

    public Users deactivateUser(Long id) {
        return usersRepository.findById(id).map(users -> {
            users.setIsActive(false);
            users.setUpdateAt(LocalDateTime.now());
            return usersRepository.save(users);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
}
