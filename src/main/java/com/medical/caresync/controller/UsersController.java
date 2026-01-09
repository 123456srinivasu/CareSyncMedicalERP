package com.medical.caresync.controller;

import com.medical.caresync.entities.Users;
import com.medical.caresync.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<Users> createUsers(@RequestBody Users users) {
        Users createdUsers = usersService.createUsers(users);
        return ResponseEntity.ok(createdUsers);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable Long id) {
        return usersService.getUsersById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users users) {
        try {
            Users updatedUsers = usersService.updateUsers(id, users);
            return ResponseEntity.ok(updatedUsers);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
        usersService.deleteUsers(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<Users>> getActiveUsers() {
        return ResponseEntity.ok(usersService.getActiveUsers());
    }

    @GetMapping("/role/{roleName}")
    public ResponseEntity<List<Users>> getUsersByRoleName(@PathVariable String roleName) {
        return ResponseEntity.ok(usersService.getUsersByRoleName(roleName));
    }

    @GetMapping("/role/id/{roleId}")
    public ResponseEntity<List<Users>> getUsersByRoleId(@PathVariable Integer roleId) {
        return ResponseEntity.ok(usersService.getUsersByRoleId(roleId));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Users> deactivateUser(@PathVariable Long id) {
        try {
            Users deactivatedUser = usersService.deactivateUser(id);
            return ResponseEntity.ok(deactivatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
