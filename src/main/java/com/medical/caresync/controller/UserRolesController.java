package com.medical.caresync.controller;

import com.medical.caresync.entities.UserRoles;
import com.medical.caresync.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users/{userId}/roles")
public class UserRolesController {

    private final UserRolesService userRolesService;

    @Autowired
    public UserRolesController(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }

    /**
     * POST /api/users/{userId}/roles
     * Assign a role to a user.
     * Body: { "roleId": 2 }
     */
    @PostMapping
    public ResponseEntity<?> assignRole(@PathVariable Long userId, @RequestBody Map<String, Long> body) {
        try {
            Long roleId = body.get("roleId");
            if (roleId == null) {
                return ResponseEntity.badRequest().body("roleId is required in request body.");
            }
            UserRoles assigned = userRolesService.assignRole(userId, roleId);
            return ResponseEntity.ok(assigned);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * GET /api/users/{userId}/roles
     * Get all roles assigned to a specific user.
     */
    @GetMapping
    public ResponseEntity<?> getRolesByUser(@PathVariable Long userId) {
        try {
            List<UserRoles> roles = userRolesService.getRolesByUserId(userId);
            return ResponseEntity.ok(roles);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/users/{userId}/roles/{userRoleId}
     * Remove a specific role assignment from a user.
     */
    @DeleteMapping("/{userRoleId}")
    public ResponseEntity<?> removeRole(@PathVariable Long userId, @PathVariable Long userRoleId) {
        try {
            userRolesService.removeRole(userRoleId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
