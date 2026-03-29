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
        LOGGER.info("Starting user registration for email: {}", dto.getEmail());

        // Validate role exists
        Role role = roleRepository.findByRoleName(dto.getRoleName());
        if (role == null) {
            LOGGER.error("Role not found: {}", dto.getRoleName());
            throw new BadRequestException("Role not found: " + dto.getRoleName());
        }

        // Create Users entity
        Users user = new Users();
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setIsActive(dto.getIsActive());
        user.setIsTemporary(dto.getIsTemporary());
        user.setCreatedBy(dto.getCreatedBy());
        user.setUpdatedBy(dto.getUpdatedBy());
        user.setFirstName(dto.getFirstName());
        user.setMiddleName(dto.getMiddleName() != null && !dto.getMiddleName().trim().isEmpty() ? dto.getMiddleName() : null);
        user.setLastName(dto.getLastName());
        user.setCity(dto.getCity());
        user.setStateLookupId(dto.getStateLookupId());
        user.setDistrictLookupId(dto.getDistrictLookupId());
        user.setMandalLookupId(dto.getMandalLookupId());
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

    @Transactional
    public Users updateUser(Long userId, UserRegistrationDTO dto) {
        LOGGER.info("Starting user update for user ID: {}", userId);

        // Find the existing user
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found with id: " + userId));

        // Determine the role name to use (check roleName first, then userRoles list)
        String roleNameToUse = dto.getRoleName();
        if ((roleNameToUse == null || roleNameToUse.trim().isEmpty()) && dto.getUserRoles() != null && !dto.getUserRoles().isEmpty()) {
            try {
                Object firstUserRole = dto.getUserRoles().get(0);
                if (firstUserRole instanceof java.util.Map) {
                    java.util.Map<?, ?> urMap = (java.util.Map<?, ?>) firstUserRole;
                    Object roleObj = urMap.get("role");
                    if (roleObj instanceof java.util.Map) {
                        java.util.Map<?, ?> roleMap = (java.util.Map<?, ?>) roleObj;
                        Object nameObj = roleMap.get("roleName");
                        if (nameObj != null) roleNameToUse = nameObj.toString();
                    }
                }
            } catch (Exception e) {
                LOGGER.warn("Failed to extract role name from userRoles list: {}", e.getMessage());
            }
        }

        Role newRole = (roleNameToUse != null && !roleNameToUse.trim().isEmpty()) 
                ? roleRepository.findByRoleName(roleNameToUse) : null;

        // Update user fields
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setIsActive(dto.getIsActive());
        user.setIsTemporary(dto.getIsTemporary());
        user.setUpdatedBy(dto.getUpdatedBy());
        user.setFirstName(dto.getFirstName());
        user.setMiddleName(dto.getMiddleName() != null && !dto.getMiddleName().trim().isEmpty() ? dto.getMiddleName() : null);
        user.setLastName(dto.getLastName());
        user.setCity(dto.getCity());
        user.setStateLookupId(dto.getStateLookupId());
        user.setDistrictLookupId(dto.getDistrictLookupId());
        user.setMandalLookupId(dto.getMandalLookupId());
        user.setUpdateAt(LocalDateTime.now());

        // Handle role update: check if role has changed
        if (newRole != null) {
            boolean hasRole = user.getUserRoles().stream()
                    .anyMatch(ur -> ur.getRole().getRoleName().equals(newRole.getRoleName()));

            if (!hasRole) {
                // Modify the managed collection directly - this is the safest Hibernate pattern
                user.getUserRoles().clear();
                
                UserRoles userRole = new UserRoles();
                userRole.setUser(user);
                userRole.setRole(newRole);
                
                user.getUserRoles().add(userRole);
                
                LOGGER.info("Updating role to: {} for user ID: {}", newRole.getRoleName(), userId);
            }
        }

        Users savedUser = usersRepository.save(user);
        LOGGER.info("User updated successfully with ID: {}", savedUser.getUserId());
        return savedUser;
    }
}
