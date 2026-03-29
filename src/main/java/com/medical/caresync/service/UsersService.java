package com.medical.caresync.service;

import com.medical.caresync.dto.PageResponse;
import com.medical.caresync.dto.UsersResponseDTO;
import com.medical.caresync.entities.Role;
import com.medical.caresync.entities.UserRoles;
import com.medical.caresync.entities.Users;
import com.medical.caresync.repository.RolePermissionRepository;
import com.medical.caresync.repository.UserCredentialsRepository;
import com.medical.caresync.repository.UserSpecification;
import com.medical.caresync.repository.UsersRepository;
import com.medical.caresync.util.PageMapper;
import com.medical.caresync.util.UsersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;
    private final UserCredentialsRepository userCredentialsRepository;
    private final RolePermissionRepository rolePermissionRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository, 
                        UserCredentialsRepository userCredentialsRepository,
                        RolePermissionRepository rolePermissionRepository) {
        this.usersRepository = usersRepository;
        this.userCredentialsRepository = userCredentialsRepository;
        this.rolePermissionRepository = rolePermissionRepository;
    }

    public List<Users> getAllowedUsersByRoleId(Integer roleId) {
        // 1. Get all allowed roles for the given user role ID
        List<Role> allowedRoles = rolePermissionRepository.findAllowedRoles(roleId);
        
        // 2. Extract allowed role IDs
        List<Long> roleIds = allowedRoles.stream()
                .map(r -> Long.valueOf(r.getRoleId()))
                .toList();

        if (roleIds.isEmpty()) {
            return java.util.Collections.emptyList();
        }

        // 3. Find all users who have at least one of these roles (including inactive, excluding deleted)
        return usersRepository.findAll().stream()
                .filter(u -> !u.getIsDeleted())
                .filter(u -> u.getUserRoles().stream()
                        .anyMatch(ur -> roleIds.contains(Long.valueOf(ur.getRole().getRoleId()))))
                .toList();
    }

    public Users createUsers(Users users) {
        if (users.getUserRoles() != null) {
            for (UserRoles userRole : users.getUserRoles()) {
                userRole.setUser(users); // Set back-reference so user_id FK is populated
            }
        }
        return usersRepository.save(users);
    }

    @Transactional(readOnly = true)
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Users> getUsersById(Long id) {
        return usersRepository.findById(id)
                .filter(u -> !u.getIsDeleted());
    }


    public Users updateUsers(Long id, Users usersDetails) {
        return usersRepository.findById(id).map(users -> {
            users.setPhone(usersDetails.getPhone());
            users.setEmail(usersDetails.getEmail());
            users.setIsActive(usersDetails.getIsActive());
            users.setIsTemporary(usersDetails.getIsTemporary());
            users.setFirstName(usersDetails.getFirstName());
            users.setMiddleName(usersDetails.getMiddleName());
            users.setLastName(usersDetails.getLastName());
            users.setCity(usersDetails.getCity());
            users.setStateLookupId(usersDetails.getStateLookupId());
            users.setDistrictLookupId(usersDetails.getDistrictLookupId());
            users.setMandalLookupId(usersDetails.getMandalLookupId());
            users.setUpdatedBy(usersDetails.getUpdatedBy());
            return usersRepository.save(users);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public void deleteUsers(Long id) {
        usersRepository.findById(id).ifPresent(user -> {
            user.setIsDeleted(true);
            usersRepository.save(user);
        });
    }

    @Transactional(readOnly = true)
    public List<Users> getActiveUsers() {
        return usersRepository.findAll().stream()
                .filter(u -> u.getIsActive() && !u.getIsDeleted())
                .toList();
    }

    @Transactional(readOnly = true)
    public List<Users> getUsersByRoleName(String roleName) {
        return usersRepository.findUsersByRoleName(roleName);
    }

    @Transactional(readOnly = true)
    public List<Users> getUsersByRoleId(Long roleId) {
        return usersRepository.findUsersByRoleId(roleId);
    }

    public Users deactivateUser(Long id) {
        return usersRepository.findById(id).map(users -> {
            users.setIsActive(false);
            users.setUpdateAt(LocalDateTime.now());
            return usersRepository.save(users);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public PageResponse<UsersResponseDTO> getUsers(
            Boolean active, Long roleId, String roleName, Pageable pageable) {
        Page<Users> page = usersRepository.findAll(
                UserSpecification.withFilters(active, roleId, roleName), pageable);
        return PageMapper.mapToPageResponse(page, UsersUtil::mapToUserResponse );
    }

    @Transactional(readOnly = true)
    public Users login(String loginId, String password) {
        return userCredentialsRepository.findByLoginId(loginId)
                .filter(credentials -> credentials.getPassword().equals(password))
                .filter(credentials -> credentials.getIsActive() != null && credentials.getIsActive())
                .map(credentials -> credentials.getUser())
                .filter(user -> user.getIsActive() && !user.getIsDeleted())
                .orElseThrow(() -> new RuntimeException("Invalid credentials or user is inactive"));
    }

}
