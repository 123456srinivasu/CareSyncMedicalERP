package com.medical.caresync.controller;

import com.medical.caresync.entities.Users;
import com.medical.caresync.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UsersService usersService;


    @GetMapping
    public ResponseEntity<List<Users>> getUsers(@RequestParam(required = false) Boolean active,
                                                         @RequestParam(required = false) Long roleId,
                                                         @RequestParam(required = false) Long campId) {
        try{
           return ResponseEntity.ok(usersService.getActiveUsers());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }

    }
}
