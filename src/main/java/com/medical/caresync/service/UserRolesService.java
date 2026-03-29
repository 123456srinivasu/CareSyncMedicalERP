package com.medical.caresync.service;

import com.medical.caresync.entities.Role;
import com.medical.caresync.entities.UserRoles;
import com.medical.caresync.entities.Users;
import com.medical.caresync.repository.RoleRepository;
import com.medical.caresync.repository.UserRolesRepository;
import com.medical.caresync.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserRolesService {

    private final UserRolesRepository userRolesRepository;
    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserRolesService(UserRolesRepository userRolesRepository,
                            UsersRepository usersRepository,
                            RoleRepository roleRepository) {
        this.userRolesRepository = userRolesRepository;
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * Assign a role to a user.
     * roleId must be provided inside the UserRoles body.
     */
    public UserRoles assignRole(Long userId, Long roleId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Role role = roleRepository.findById(roleId.intValue())
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));

        // Prevent duplicate user-role combinations
        boolean alreadyAssigned = user.getUserRoles().stream()
                .anyMatch(ur -> ur.getRole().getRoleId().equals(role.getRoleId()));
        if (alreadyAssigned) {
            throw new RuntimeException("Role '" + role.getRoleName() + "' is already assigned to user id: " + userId);
        }

        UserRoles userRole = new UserRoles();
        userRole.setUser(user);
        userRole.setRole(role);
        return userRolesRepository.save(userRole);
    }

    /**
     * Get all roles assigned to a specific user.
     */
    @Transactional(readOnly = true)
    public List<UserRoles> getRolesByUserId(Long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return user.getUserRoles().stream().toList();
    }

    /**
     * Remove (unassign) a specific role from a user.
     */
    public void removeRole(Long userRoleId) {
        if (!userRolesRepository.existsById(userRoleId)) {
            throw new RuntimeException("UserRole not found with id: " + userRoleId);
        }
        userRolesRepository.deleteById(userRoleId);
    }
}
