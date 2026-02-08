package com.medical.caresync.service;

import com.medical.caresync.dto.UserRegistrationDTO;
import com.medical.caresync.entities.Role;
import com.medical.caresync.entities.UserRoles;
import com.medical.caresync.entities.Users;
import com.medical.caresync.exceptions.BadRequestException;
import com.medical.caresync.repository.RoleRepository;
import com.medical.caresync.repository.UserRolesRepository;
import com.medical.caresync.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UserRegistrationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationService.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Transactional
    public Users registerUser(UserRegistrationDTO dto) {
        LOGGER.info("Starting user registration for login ID: {}", dto.getLoginId());

        // Validate role exists
        Role role = roleRepository.findByRoleName(dto.getRoleName());
        if (role == null) {
            LOGGER.error("Role not found: {}", dto.getRoleName());
            throw new BadRequestException("Role not found: " + dto.getRoleName());
        }

        // Create Users entity
        Users user = new Users();
        user.setUserName(dto.getUserName());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setIsActive(dto.getIsActive());
        user.setLoginId(dto.getLoginId());
        user.setPassword(dto.getPassword());
        user.setIsTemporary(dto.getIsTemporary());
        user.setCreatedBy(dto.getCreatedBy());
        user.setUpdatedBy(dto.getUpdatedBy());
        user.setFirstName(dto.getFirstName());
        user.setMiddleName(dto.getMiddleName());
        user.setLastName(dto.getLastName());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());

        // Save user first to get the user_id
        Users savedUser = usersRepository.save(user);
        LOGGER.info("User created with ID: {}", savedUser.getUserId());

        // Create UserRole entity
        UserRoles userRole = new UserRoles();
        userRole.setUser(savedUser);
        userRole.setRole(role);

        // Save user role
        userRolesRepository.save(userRole);
        LOGGER.info("User role assigned: {} to user ID: {}", role.getRoleName(), savedUser.getUserId());

        return savedUser;
    }
}
